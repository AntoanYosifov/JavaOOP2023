package reflectionAnnotationHomeWork.barracksWars;

import reflectionAnnotationHomeWork.barracksWars.core.commands.AddUnitCommand;
import reflectionAnnotationHomeWork.barracksWars.core.commands.FightCommand;
import reflectionAnnotationHomeWork.barracksWars.core.commands.ReportCommand;
import reflectionAnnotationHomeWork.barracksWars.core.commands.RetireCommand;
import reflectionAnnotationHomeWork.barracksWars.interfaces.Repository;
import reflectionAnnotationHomeWork.barracksWars.interfaces.UnitFactory;
import reflectionAnnotationHomeWork.barracksWars.core.Engine;
import reflectionAnnotationHomeWork.barracksWars.core.factories.UnitFactoryImpl;
import reflectionAnnotationHomeWork.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Engine engine = new Engine(repository, unitFactory);
        engine.registerCommand(AddUnitCommand.class);
        engine.registerCommand(FightCommand.class);
        engine.registerCommand(ReportCommand.class);
        engine.registerCommand(RetireCommand.class);
        engine.run();
    }
}
