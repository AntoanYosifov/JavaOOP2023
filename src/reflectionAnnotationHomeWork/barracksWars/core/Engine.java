package reflectionAnnotationHomeWork.barracksWars.core;

import reflectionAnnotationHomeWork.barracksWars.core.commands.Command;
import reflectionAnnotationHomeWork.barracksWars.core.commands.NamedCommand;
import reflectionAnnotationHomeWork.barracksWars.interfaces.Repository;
import reflectionAnnotationHomeWork.barracksWars.interfaces.Runnable;
import reflectionAnnotationHomeWork.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;
    List<Class<?>> registeredCommands = new ArrayList<>();

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        }
    }

    public  void registerCommand(Class<?> commandClass) {
        NamedCommand annotation = commandClass.getAnnotation(NamedCommand.class);
        if (annotation == null) {
            throw new IllegalArgumentException();
        }

        registeredCommands.add(commandClass);
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
        Command command = buildCommand(data, commandName);
        if (command == null) {
            throw new IllegalArgumentException("Can't find command " + commandName);
        }
        return command.execute();
    }

    private Command buildCommand(String[] data, String commandName) {
        Command command = null;
        for (Class<?> registeredCommandClass : registeredCommands) {
            NamedCommand annotation = registeredCommandClass.getAnnotation(NamedCommand.class);
            if (annotation.commandName().equals(commandName)) {
                try {
                    command = (Command) registeredCommandClass.getConstructor(String[].class, Repository.class, UnitFactory.class)
                            .newInstance(data, repository, unitFactory);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                         NoSuchMethodException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
        return command;
    }
}
