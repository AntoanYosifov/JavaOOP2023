package reflectionAnnotationHomeWork.barracksWars.core.commands;

import reflectionAnnotationHomeWork.barracksWars.interfaces.Repository;
import reflectionAnnotationHomeWork.barracksWars.interfaces.UnitFactory;
@NamedCommand(commandName = "report")
public class ReportCommand extends Command{
    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = this.getRepository().getStatistics();
        return output;
    }
}
