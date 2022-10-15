import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class GameTest {
    Game game = new Game();
    Player mira = new Player(1, "Ivan", 10);
    Player collapse = new Player(2, "Yaroslav", 20);
    Player miposhka = new Player(3, "Magomed", 25);
    Player yatoro = new Player(4, "Sasha", 15);
    Player toronto = new Player(5, "Nikita", 5);
    Player pgg = new Player(6, "Vladimir", 25);
    Player evilArthas = new Player(7, "Bogdan", 990);

    @BeforeEach
    public void setup() {
        game.register("Ivan", mira);
        game.register("Yaroslav", collapse);
        game.register("Magomed", miposhka);
        game.register("Sasha", yatoro);
        game.register("Nikita", toronto);
    }

    @Test
    public void shouldRegisterPlayer () {
        game.register("Vladimir", pgg);
        Map<String, Player> actual = game.getRegisteredPlayers();

        Assertions.assertTrue(actual.containsKey("Vladimir"));
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/resultOfGames.csv")
    public void roundTest (String player1, String player2, int expected) {
        game.register("Vladimir", pgg);
        int actual = game.round(player1, player2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetId() {
        int expected = 1;
        int actual = mira.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisteredExceptions() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Bogdan");
        });
    }
}
