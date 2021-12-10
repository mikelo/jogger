#  minimalistic approach to JSON format logging

to build springboot app on openshift:

    mvn package oc:build -Popenshift
    mvn package oc:deploy -Popenshift -DLEVEL=info

to change log level at runtime

    oc set env dc jogger -e LEVEL=info

call the newly created service to produce events:

    curl $(oc get routes.route.openshift.io -o jsonpath='{.items[].spec.host}')

we can now follow the pod's log:

    oc logs -f $(oc get pod --field-selector=status.phase=Running -o jsonpath='{.items[].metadata.name}')

# example of correspondence between code and log in standard output:
in [LoggingController.java](src/main/java/com/ibm/jogger/LoggingController.java)

    ThreadContext.put("MSG",  "message_id_test");   
    ThreadContext.put("TRN",  "transaction_id_test");    
    logger.error("test message CON custom");

corresponds to:

    {"@timestamp":"2021-12-10T18:21:55.609+0100","version":"1.0","message":"test message CON custom","logger":"com.ibm.jogger.Jogger","MSG":"message_id_test","TRN":"transaction_id_test","line_number":29,"class":"com.ibm.jogger.Jogger","@version":2,"source_host":"thinkpod","thread_name":"com.ibm.jogger.Jogger.main()","level":"ERROR","file":"Jogger.java","method":"main"}

and this line of code containing the runtime exception:

    Exception  e  =  new  RuntimeException("This is only a test!");      
    logger.info("This is a simple message at INFO level. "  +
    "It will be hidden.");        
    logger.error("This is a simple message at ERROR level. "  +
    "This is the minimum visible level.", e);

will be translated into:

    {"@timestamp":"2021-12-10T18:21:55.611+0100","version":"1.0","message":"This is a simple message at ERROR level. This is the minimum visible level.","logger":"com.ibm.jogger.Jogger","MSG":"message_id_test","TRN":"transaction_id_test","line_number":37,"class":"com.ibm.jogger.Jogger","@version":2,"source_host":"thinkpod","thread_name":"com.ibm.jogger.Jogger.main()","level":"ERROR","file":"Jogger.java","method":"main","error.type":"java.lang.RuntimeException","error.message":"This is only a test!","error.stack_trace":"java.lang.RuntimeException: This is only a test!\n\tat com.ibm.jogger.Jogger.main(Jogger.java:34)\n\tat org.codehaus.mojo.exec.ExecJavaMojo$1.run(ExecJavaMojo.java:254)\n\tat java.base/java.lang.Thread.run(Thread.java:829)\n"}

NB: the appearance of the JSON output can be configured [JSONEventLayout.json](src/main/resources/JSONEventLayout.json)


---

## Monolithic tests on localhost:

to run the java part:

    mvn exec:java

to run springboot app on localhost:
  
    mvn spring-boot:run
