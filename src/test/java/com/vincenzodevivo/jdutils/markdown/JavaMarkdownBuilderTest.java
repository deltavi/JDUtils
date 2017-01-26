package com.vincenzodevivo.jdutils.markdown;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Vincenzo De Vivo on 26/01/2017.
 */
public class JavaMarkdownBuilderTest {

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    @Test
    public void test() throws IOException, ClassNotFoundException {
        /*print(EmptyUtils.class);
        print(StringCleaner.class);
        print(StringSplitter.class);
        print(MimeTypesUtils.class);
        */

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        String packageName = "com.vincenzodevivo.jdutils";
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = contextClassLoader.getResources(path);
        while (resources.hasMoreElements()) {
            URL dir = resources.nextElement();
            if (dir.toString().contains("target/classes/")) {
                List<Class> classList = findClasses(new File(dir.getFile()), packageName);
                for (Class aClass : classList) {
                    //System.out.println(aClass);
                    print(aClass);
                }
            }
        }
    }

    public void print(Class cls) {

        System.out.println("## " + cls.getSimpleName());
        String name = cls.getName() + ".";
        String packageName = cls.getPackage().getName()+ ".";
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            if (method.getModifiers() == (Modifier.PUBLIC | Modifier.STATIC) || method.getModifiers() == Modifier.PUBLIC) {
                String str = method.toString();

                if (str.contains(name)) {
                    str = str.replace(name, "");
                    str = str.replace(packageName, "");

                    str = str.replace("java.lang.", "");
                    //str = str.replace("java.util.", "");
                    str = str.replace(",", ", ");

                    System.out.println("```java");
                    System.out.println(str);
                    System.out.println("```");
                    System.out.println("*Description*");
                }
            }
        }
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            if (field.getModifiers() ==  (Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL)){
                String str = field.toString();
                str = str.replace(name, "");
                str = str.replace(packageName, "");

                str = str.replace("java.lang.", "");
                //str = str.replace("java.util.", "");
                str = str.replace(",", ", ");
                System.out.println("```java");
                System.out.println(str);
                System.out.println("```");
                System.out.println("*Description*");
            }
        }
        /*String str = method.toString();
        if (str.contains(cls.getName())) {
            System.out.println(str);
        }*/
    }
}
