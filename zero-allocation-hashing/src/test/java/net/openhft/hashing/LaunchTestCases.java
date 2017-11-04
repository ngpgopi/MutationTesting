package net.openhft.hashing;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;


public class LaunchTestCases {

        public static void launchTest(){
            org.junit.runner.Result result = JUnitCore.runClasses(City64_1_1_Test.class);
            for (Failure failure : result.getFailures()){
                System.out.println(failure.toString());
            }

            result = JUnitCore.runClasses(FarmHashTest.class);
            for (Failure failure : result.getFailures()){
                System.out.println(failure.toString());
            }
    }

}
