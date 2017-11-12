package com.object.oriented.mutation.launcher.app;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.Modifier;

public class AccessModifierMutant {

    public void mutate(CtClass ctClass){
        try {
            ctClass.defrost();
            CtField[] fields = ctClass.getDeclaredFields();
            for(CtField field : fields){
                field.setModifiers(Modifier.PUBLIC+Modifier.STATIC);
            }
            ctClass.writeFile("out/production/classes");

        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
