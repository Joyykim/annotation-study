package person;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {

        BeanFactory beanFactory = new BeanFactory();
        try {
            beanFactory.componentScan();
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        Person person = (Person) beanFactory.getBean("person.Person");
        person.print();
    }
}
