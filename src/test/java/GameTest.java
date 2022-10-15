import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

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
        game.register(mira);
        game.register(collapse);
        game.register(miposhka);
        game.register(yatoro);
        game.register(toronto);
    }

    @Test
    public void shouldRegisterPlayer () {
        List<Player> expected = asList(mira, collapse, miposhka, yatoro, toronto, pgg);
        game.register(pgg);
        List<Player> actual = game.getRegisteredPlayers();

        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/resultOfGames.csv")
    public void roundTest (String player1, String player2, int expected) {
        game.register(pgg);
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
