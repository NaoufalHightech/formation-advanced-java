package jour3.ex1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionExample {
    public static void main(String[] args) {

        // Obtenir des informations sur la classe Personne
        Class<?> personneClass = Personne.class;
        // Afficher le nom de la classe
        System.out.println("Nom de la classe : " + personneClass.getName());
        // Afficher les méthodes publiques de la classe
        System.out.println("Méthodes publiques :");
        Method[] methods = personneClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        // Afficher les champs de la classe
        System.out.println("Champs :");
        Field[] fields = personneClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getName() + " " + field.getName());
        }

        /**
         * Class<?> clazz = Class.forName("reflectivity.Person");
         *
         *             System.out.println("Class name: " + clazz.getSimpleName());
         *             System.out.println("Public methods: " + Arrays.stream(clazz.getDeclaredMethods()).map(Method::getName).collect(Collectors.joining(", ")));
         *             System.out.println("Fields: " + Arrays.stream(clazz.getDeclaredFields()).map(Field::getName).collect(Collectors.joining(", ")));
         */

    }
}
