package com.ascending;

import com.ascending.basic.TestAll;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRunner {
    public final static Logger logger = LoggerFactory.getLogger(TestRunner.class);
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestAll.class);

        for (Failure failure : result.getFailures()) {
            logger.error(failure.toString());
        }

        logger.info("{}", result.wasSuccessful());
    }
}
