package com.object.oriented.mutation.launcher.app;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.IOException;

public class MethodMutant {

    public void mutate(CtClass ctClass) {
        ctClass.defrost();
        CtMethod[] methods = ctClass.getDeclaredMethods();
        for(CtMethod method : methods){
            method.setName("_"+method.getName());
        }
        try {
            ctClass.writeFile("out/production/classes");
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
