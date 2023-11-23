package reflectionAnnotationHomeWork.barracksWars.core.factories;

import reflectionAnnotationHomeWork.barracksWars.interfaces.Unit;
import reflectionAnnotationHomeWork.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "reflectionAnnotationHomeWork.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
        Class<?> unitTypeClass;
        try {
            unitTypeClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> constructor = unitTypeClass.getConstructor();
            return  (Unit) constructor.newInstance();
        } catch (ClassNotFoundException |
                 NoSuchMethodException |
                 InstantiationException |
                 IllegalAccessException |
                 InvocationTargetException e
        ) {throw new IllegalStateException(e);}

    }
}
