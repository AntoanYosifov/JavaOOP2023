package reflectionAnnotationHomeWork.harvestingFields_01;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
        Field[] declaredFields = richSoilLandClass.getDeclaredFields();


        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!"HARVEST".equals(command)) {
            for (Field declaredField : declaredFields) {
                String accessModifierName = getAccessModifierName(declaredField.getModifiers());

                if (command.equals("all")
                        || command.equals(accessModifierName)) {
                    System.out.println(accessModifierName
                            + " " + declaredField.getType().getSimpleName()
                            + " " + declaredField.getName());
                }
            }


            command = scanner.nextLine();
        }
    }

    private static String getAccessModifierName(int modifiers) {
        String modifierName;
        if (Modifier.isPublic(modifiers)) {
            modifierName = "public";
        } else if (Modifier.isProtected(modifiers)) {
            modifierName = "protected";
        } else if (Modifier.isPrivate(modifiers)) {
            modifierName = "private";
        } else {
            throw new IllegalArgumentException("Expected to be either " + "public" + ", " + "private" + ", or " + "protected.");
        }
        return modifierName;
    }
}
