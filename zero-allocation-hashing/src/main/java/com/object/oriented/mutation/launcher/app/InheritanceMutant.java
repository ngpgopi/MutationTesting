package com.object.oriented.mutation.launcher.app;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InheritanceMutant {

    public void mutate(CtClass ctClass){
        ctClass.defrost();
        try {
            CtField[] fields = ctClass.getDeclaredFields();
            List<String> fieldNames = getFieldNames(fields);
            for(CtClass nestedClass : ctClass.getNestedClasses()){
                System.out.println("working of nested class:" + nestedClass.getName());
                deleteHiddenVariable(nestedClass,fieldNames);
            }
            /*for(CtClass nestedClass : ctClass.getNestedClasses()){
                System.out.println("working of nested class:" + nestedClass.getName());
                addHiddenVariable(nestedClass,fields);
            }*/
            ctClass.writeFile("out/production/classes");
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getMatchedFields(List<String> fieldNames, List<String> nestedFieldNames) {
        List<String> matchedFields = new ArrayList<>();
        for(String fieldName : fieldNames){
            if(nestedFieldNames.contains(fieldName)){
                matchedFields.add(fieldName);
            }
        }
        return matchedFields;
    }

    private List<String> getFieldNames(CtField[] fields) {
        List<String> fieldNames = new ArrayList<>();
        for(CtField ctField: fields){
            fieldNames.add(ctField.getName());
        }
        return fieldNames;
    }


    private void deleteHiddenVariable(CtClass nestedClass, List<String> fieldNames) throws NotFoundException, CannotCompileException, IOException {
        CtField[] nestedFields = nestedClass.getDeclaredFields();
        List<String> nestedFieldNames = getFieldNames(nestedFields);
        List<String> matchedFields = getMatchedFields(fieldNames,nestedFieldNames);
        if(matchedFields.size()>0){
            for(String matchedField : matchedFields){
                System.out.println("Removing field : " + matchedField);
                nestedClass.removeField(nestedClass.getField(matchedField));
                nestedClass.writeFile("out/production/classes");
            }
        }
    }

    private void addHiddenVariable(CtClass nestedClass, CtField[] fields) throws CannotCompileException, IOException {
        for(CtField field :fields){
            System.out.println("Adding field : " + field.getName());
            nestedClass.addField(field);
            nestedClass.writeFile("out/production/classes");
        }
    }


}
