package reflectionAnnotationHomeWork.barracksWars.core.commands;

import reflectionAnnotationHomeWork.barracksWars.interfaces.Repository;
import reflectionAnnotationHomeWork.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

@NamedCommand(commandName = "retire")
public class RetireCommand extends Command{

    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        try {
            getRepository().removeUnit(getData()[1]);
        } catch (ExecutionControl.NotImplementedException | IllegalStateException e) {
            throw new IllegalArgumentException("No such units in repository.");
        }
        return getData()[1] + " retired!";
    }
}
