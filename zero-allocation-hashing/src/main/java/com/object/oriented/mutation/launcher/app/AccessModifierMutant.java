package com.object.oriented.mutation.launcher.app;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.Modifier;

public class AccessModifierMutant {

    private ClassPool pool;

    public AccessModifierMutant(ClassPool pool){
        this.pool = pool;
    }

    public void mutate(String className){
        try {
            CtClass ctClass = pool.get(className);
            CtField[] fields = ctClass.getDeclaredFields();
            //CtMethod[] methods = ctClass.getDeclaredMethods();
            for(CtField field : fields){
                field.setModifiers(Modifier.PUBLIC+Modifier.STATIC+Modifier.FINAL);
            }
            ctClass.writeFile("out/production/classes");

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
