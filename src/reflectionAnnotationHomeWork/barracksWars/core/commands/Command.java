package reflectionAnnotationHomeWork.barracksWars.core.commands;

import reflectionAnnotationHomeWork.barracksWars.interfaces.Executable;
import reflectionAnnotationHomeWork.barracksWars.interfaces.Repository;
import reflectionAnnotationHomeWork.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
