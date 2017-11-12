package com.object.oriented.mutation.launcher.app;


import javassist.ClassPool;
import net.openhft.hashing.LaunchTestCases;

import java.io.File;
import java.io.IOException;

import static com.object.oriented.mutation.launcher.app.ConfigFileLoader.loadVarRegex;

public class Launcher {

    public static void main(String[] args) {

        //read configuration file - includes test cases to be run and inputs
        readConfigFile();

        //Runs parser to insert logging statement in classes
        runParser();

        //Runs all test cases to generate trace file from original app
        //runTestCaseToGenerateTrace();

        //read trace file and generate mutation table
        readTraceAndGenerateMutationTable();

        //runTestCaseToGenerateTrace();

        ClassPool pool = ClassPool.getDefault();
        AccessModifierMutant modifierMutant = new AccessModifierMutant(pool);
        modifierMutant.mutate("net.openhft.hashing.CityAndFarmHash_1_1");

        createTraceBackup();

        runTestCaseToGenerateTrace();

        traceFileComparator();


    }

    private static void traceFileComparator() {
        try {
            TraceFileComparator.hashCodeComparator();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createTraceBackup() {
        String filePath = "TraceFile.txt";
        File fileToBackup = new File(filePath);
        filePath = "UnMutatedTraceFile.txt";
        File newFile = new File(filePath);
        fileToBackup.renameTo(newFile);

    }

    private static void readConfigFile() {
        //loadConfig();
        loadVarRegex();
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
