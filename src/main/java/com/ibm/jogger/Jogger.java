package com.ibm.jogger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class Jogger {

    private static final Logger logger = LogManager.getLogger(Jogger.class);

    public static void main( String[] args ) {

        logger.trace("Entering application.");
        // Bar bar = new Bar();
        // if (!bar.doIt()) {
        //     logger.error("Didn't do it.");
        // }
        logger.error("error message");
        logger.trace("trace message");
        
        Marker marker = MarkerManager.getMarker("CLASS");
        Child child = new Child();

        System.out.println("------- Parent Logger ----------");
        child.log(null);
        child.log(marker);
        child.logFromChild(null);
        child.logFromChild(marker);
        child.parentLog(null);
        child.parentLog(marker);

        child.setLogger(child.childLogger);

        System.out.println("------- Parent Logger set to Child Logger ----------");
        child.log(null);
        child.log(marker);
        child.logFromChild(null);
        child.logFromChild(marker);
    }
}