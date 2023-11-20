package reflectionAnnotationHomeWork.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        Person antoan = new Person("antoan",31 );
        String fieldName = "age";

        try {
            Field field = personClass.getDeclaredField(fieldName);

            System.out.println(field.getType());
            field.setAccessible(true);
            System.out.println(field.getInt(antoan));
        } catch (NoSuchFieldException e) {
            System.out.println("Couldn't find field " + fieldName);
        } catch (IllegalAccessException e) {
            System.out.println("Couldn't access field " + fieldName );
        }
    }
}
