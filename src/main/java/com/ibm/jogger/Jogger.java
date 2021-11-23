package com.ibm.jogger;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.ThreadContext;
import org.json.JSONObject;

public class Jogger {

    private static final Logger logger = LogManager.getLogger();

    public static void main( String[] args ) {

        logger.info("test message");
        // Bar bar = new Bar();
        // if (!bar.doIt()) {
        //     logger.error("Didn't do it.");
        // }

        logger.error("test message");
        logger.trace("test message");
        logger.warn("test message");
        ThreadContext.put("MSG", "message_id_test");
        ThreadContext.put("TRN", "transaction_id_test");
        // Map<String,String> msgMap = new HashMap<>();
        // msgMap.put("MSG", "2292929");
        // JSONObject message = new JSONObject(msgMap);
        logger.error("test message");
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