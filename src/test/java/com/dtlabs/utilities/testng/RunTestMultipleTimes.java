package com.dtlabs.utilities.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RunTestMultipleTimes {

        // run multipe times and in parallel

        @Test(invocationCount = 5, threadPoolSize = 3)
        public void testMethod() {
            System.out.println("Executing testMethod");
            Assert.assertTrue(true);
        }
    }
