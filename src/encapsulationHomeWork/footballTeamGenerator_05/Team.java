package encapsulationHomeWork.footballTeamGenerator_05;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        Validators.validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPLayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        int toRemoveIndex = -1;
        for (int i = 0; i < this.players.size(); i++) {
            if (this.players.get(i).getName().equals(name)) {
                toRemoveIndex = i;
                break;
            }
        }

        if (toRemoveIndex == -1) {
            throw new IllegalArgumentException("Player " + name + " is not in " + getName() + " team.");
        }

        this.players.remove(toRemoveIndex);
    }

    public double getRating() {
        return Math.round(players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0));
    }


}
