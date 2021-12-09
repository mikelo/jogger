package com.ibm.jogger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class Jogger {

    private static final Logger logger = LogManager.getLogger();

    public static void main( String[] args ) {

        logger.info("test message");
        // Bar bar = new Bar();
        // if (!bar.doIt()) {
        //     logger.error("Didn't do it.");
        // }

        logger.error("test message 1");
        // logger.trace("trace messages NOT supported in kibana?");
        logger.warn("test message senza custom");
        
        
        ThreadContext.put("MSG", "message_id_test");
        ThreadContext.put("TRN", "transaction_id_test");
        logger.error("test message CON custom");

        // Map<String,String> msgMap = new HashMap<>();
        // msgMap.put("MSG", "2292929");
        // JSONObject message = new JSONObject(msgMap);
        Exception e = new RuntimeException("This is only a test!");
        logger.info("This is a simple message at INFO level. " +
        "It will be hidden.");
        logger.error("This is a simple message at ERROR level. " +
        "This is the minimum visible level.", e);
          // Marker marker = MarkerManager.getMarker("MESSID.2292929");
        // Child child = new Child();

        // System.out.println("------- Parent Logger ----------");
        // child.log(null);
        // child.log(marker);
        // child.logFromChild(null);
        // child.logFromChild(marker);
        // child.parentLog(null);
        // child.parentLog(marker);

        // child.setLogger(child.childLogger);

        // System.out.println("------- Parent Logger set to Child Logger ----------");
        // child.log(null);
        // child.log(marker);
        // child.logFromChild(null);
        // child.logFromChild(marker);
    }
}