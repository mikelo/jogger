/**
 * Copyright (c) 2019 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at:
 *
 *     https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package com.ibm.jogger;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

// @RestController
// public class HelloController {

//     @RequestMapping("/")
//     public String index() {
//         return "Greetings from Spring Boot!";
//     }

// }


@RestController
public class LoggingController {

    private static final Logger logger = LogManager.getLogger();

    @RequestMapping("/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");


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

        return "Howdy! Check out the Logs to see the output...";
    }
}