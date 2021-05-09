package person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class BeanFactory {

    Map<String, Object> storage = new HashMap<>();

    public void componentScan()
            throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        ClassLoader classLoader = Person.class.getClassLoader();
        Field classesField = ClassLoader.class.getDeclaredField("classes");
        classesField.setAccessible(true);
        Object o = classesField.get(classLoader);

        ArrayList<Class<?>> classes = new ArrayList<>((Vector<Class<?>>) o);
        for (Class<?> aClass : classes) {
            if (aClass.isAnnotationPresent(Component.class)) {
                storage.put(
                        aClass.getName(),
                        aClass.getConstructor().newInstance()
                );

            }
        }
    }

    public Object getBean(String name) {
        return storage.get(name);
    }
}
