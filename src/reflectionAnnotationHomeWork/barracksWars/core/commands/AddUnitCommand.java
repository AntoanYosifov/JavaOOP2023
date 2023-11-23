package reflectionAnnotationHomeWork.barracksWars.core.commands;

import reflectionAnnotationHomeWork.barracksWars.interfaces.Repository;
import reflectionAnnotationHomeWork.barracksWars.interfaces.Unit;
import reflectionAnnotationHomeWork.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;
@NamedCommand(commandName = "add")
public class AddUnitCommand extends Command{
    public AddUnitCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = null;
        try {
            unitToAdd = this.getUnitFactory().createUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            throw new IllegalStateException(e);
        }
        this.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
