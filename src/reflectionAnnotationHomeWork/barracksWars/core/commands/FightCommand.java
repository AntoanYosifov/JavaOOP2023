package reflectionAnnotationHomeWork.barracksWars.core.commands;

import reflectionAnnotationHomeWork.barracksWars.interfaces.Repository;
import reflectionAnnotationHomeWork.barracksWars.interfaces.UnitFactory;
@NamedCommand(commandName = "fight")
public class FightCommand extends Command{
    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
