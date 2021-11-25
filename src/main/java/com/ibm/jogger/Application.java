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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

@SpringBootApplication
public class Application {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.error("test message");
        logger.trace("trace messages supported in kibana?");
        logger.warn("test message");
        ThreadContext.put("MSG", "message_id_test");
        ThreadContext.put("TRN", "transaction_id_test");
        // Map<String,String> msgMap = new HashMap<>();
        // msgMap.put("MSG", "2292929");
        // JSONObject message = new JSONObject(msgMap);
        logger.error("test message");
    }

}