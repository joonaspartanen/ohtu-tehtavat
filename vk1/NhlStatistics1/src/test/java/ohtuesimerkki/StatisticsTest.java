package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StatisticsTest {

  Reader readerStub = new Reader() {

    public List<Player> getPlayers() {
      ArrayList<Player> players = new ArrayList<>();

      players.add(new Player("Semenko", "EDM", 4, 12));
      players.add(new Player("Lemieux", "PIT", 45, 54));
      players.add(new Player("Kurri", "EDM", 37, 53));
      players.add(new Player("Yzerman", "DET", 42, 56));
      players.add(new Player("Gretzky", "EDM", 35, 89));

      return players;
    }
  };

  Statistics stats;

  @Before
  public void setUp() {
    stats = new Statistics(readerStub);
  }

  @Test
  public void searchFindsExistingPlayer() {
    Player player = stats.search("Semenko");
    assertEquals("Semenko", player.getName());
  }

  @Test
  public void searchReturnNullIfPlayerDoesNotExist() {
    Player player = stats.search("Selanne");
    assertNull(player);
  }

  @Test
  public void teamReturnsWholeTeam() {
    List<Player> team = stats.team("EDM");
    assertTrue(team.size() == 3);
  }

  @Test
  public void topScorersReturnsRightNumberOfPlayers() {
    List<Player> top = stats.topScorers(3);
    assertTrue(top.size() == 3);
  }

}