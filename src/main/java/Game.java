import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    Map<String, Player> registeredPlayers = new HashMap<>();

    public void register (String name, Player player) {
        registeredPlayers.put(name, player);
    }

    public Map<String, Player> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public int round (String player1, String player2) {
        if (!(registeredPlayers.containsKey(player1)) || !(registeredPlayers.containsKey(player2))) {
            throw new NotRegisteredException("One of players is not registered");
        }

        if (registeredPlayers.get(player1).getStrength() > registeredPlayers.get(player2).getStrength()) {
            return 1;
        } else if (registeredPlayers.get(player1).getStrength() < registeredPlayers.get(player2).getStrength()) {
            return 2;
        } else return 0;
    }
}
