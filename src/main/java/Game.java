import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> registeredPlayers = new ArrayList<>();

    public void register (Player player) {
        registeredPlayers.add(player);
    }

    public List<Player> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public int round (String player1, String player2) {
        int count = 0;
        int strengthPlayer1 = 0;
        int strengthPlayer2 = 0;
        for (Player player : registeredPlayers) {
            if (player.getName().equals(player1)) {
                count++;
                strengthPlayer1 = player.getStrength();
            }
            if (player.getName().equals(player2)) {
                count++;
                strengthPlayer2 = player.getStrength();
            }
        }
        if (count < 2) {
            throw new NotRegisteredException("One of players is not registered");
        }
        if (strengthPlayer1 > strengthPlayer2) {
            return 1;
        } else if (strengthPlayer1 < strengthPlayer2) {
            return 2;
        } else return 0;
    }
}
