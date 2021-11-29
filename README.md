# minimalistic approach to JSON format logging

to build springboot app on openshift:
```
mvn package oc:build -Popenshift -DLEVEL=info
mvn package oc:deploy -Popenshift
```

to change log level at runtime
```
oc set env dc jogger -e LEVEL=info
```
call the newly created service to produce events:
```
curl $(oc get routes.route.openshift.io -o jsonpath='{.items[].spec.host}')
```
we can now follow the pod's log:
```
oc logs -f $(oc get pod --field-selector=status.phase=Running -o jsonpath='{.items[].metadata.name}')
```
---
only runs java part on localhost:
```
mvn exec:java
```

to run springboot app on localhost:

```
mvn spring-boot:run
```
