package encapsulationHomeWork.footballTeamGenerator_05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Team> teamByName = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!"END".equals(command)) {

            String[] commandParts = command.split(";");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Team":
                    handleAddTeam(commandParts[1], teamByName);
                    break;
                case "Add":
                    handleAddPlayer(commandParts[1], commandParts[2], commandParts[3], commandParts[4], commandParts[5],
                            commandParts[6], commandParts[7], teamByName);
                    break;
                case "Remove":
                    handleRemovePlayer(commandParts[1], commandParts[2], teamByName);
                    break;
                case "Rating":
                    handleRating(commandParts[1], teamByName);
                    break;
                default:
                    throw new IllegalStateException("Unknown command" + commandName);
            }


            command = scanner.nextLine();
        }


    }

    private static void handleRating(String teamName, Map<String, Team> teamByName) {
        Team team = getTeamOrPrintNotFound(teamName, teamByName);
        if (team == null) {
            return;
        }
        System.out.println(team.getName() + " - " + (int) team.getRating());

    }

    private static void handleRemovePlayer(String teamName, String playerName, Map<String, Team> teamByName) {
        Team team = getTeamOrPrintNotFound(teamName, teamByName);
        if (team == null) {
            return;
        }
        try {
            team.removePlayer(playerName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void handleAddPlayer(String teamName, String playerName, String enduranceStr,
                                        String sprintStr, String dribbleStr, String passingStr, String shootingStr, Map<String, Team> teamByName) {
        Team team = getTeamOrPrintNotFound(teamName, teamByName);
        if (team == null) return;
        Player player;
        try {
            player = new Player(playerName,
                    Integer.parseInt(enduranceStr),
                    Integer.parseInt(sprintStr),
                    Integer.parseInt(dribbleStr),
                    Integer.parseInt(passingStr),
                    Integer.parseInt(shootingStr));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        team.addPLayer(player);
    }

    private static Team getTeamOrPrintNotFound(String teamName, Map<String, Team> teamByName) {
        Team team = teamByName.get(teamName);
        if (team == null) {
            System.out.println("Team " + teamName + " does not exist.");
            return null;
        }
        return team;
    }

    private static void handleAddTeam(String teamName, Map<String, Team> teamByName) {
        try {
            Team team = new Team(teamName);
            teamByName.put(team.getName(), team);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
