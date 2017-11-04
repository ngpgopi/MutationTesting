package com.object.oriented.mutation.launcher.app;


import net.openhft.hashing.LaunchTestCases;

public class Launcher {

    public static void main(String[] args) {

        //read configuration file - includes test cases to be run and inputs
        readConfigFile();

        //Runs parser to insert logging statement in classes
        runParser();

        //Runs all test cases to generate trace file from original app
        runTestCaseToGenerateTrace();

        //read trace file and generate mutation table
        readTraceAndGenerateMutationTable();




    }

    private static void readConfigFile() {
    }

    private static void runParser(){

    }

    private static void runTestCaseToGenerateTrace(){
        LaunchTestCases.launchTest();
    }

    private static void readTraceAndGenerateMutationTable(){
        //input - trace file
        //output - mutation map

    }

}
