package test;

import main.*;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UnoTest {
    public Game game;

    @Before
    public void setUp() throws Exception {
        game = new Uno();

        ArrayList<Player> generated_players = new ArrayList<Player>();
        for (int i = 0; i < 5; i++) { // create 5 players
            generated_players.add(new UnoPlayer("Player #" + (i + 1)));
        }
        game.setPlayers(generated_players);
    }


    @org.junit.Test
    public void testDealStartingCards() throws Exception {
        System.out.println("testDealStartingCards");
        this.game.dealStartingCards();
        for (Player player : game.getPlayers()){
            if (player.getCardGroup().cards.size() != 7){
                fail();
            }
        }
    }

    @org.junit.Test
    public void testCheckWin() throws Exception {
        game.dealStartingCards();
        assertTrue(game.checkWin());

        for (Player player : game.getPlayers()){
            player.getCardGroup().cards.clear();
        }
        assertFalse(game.checkWin());
    }

    @org.junit.Test
    public void testValidateAction() {
        assertTrue(
                game.validateAction(
                        new SpecialCard(Card.TypesOfCards.Draw, Card.ColorsOfCards.Blue),
                        new StandardCard(Card.TypesOfCards.StandardNumber, Card.ColorsOfCards.Blue, 5)
                )
        );
        assertTrue(
                game.validateAction(
                        new SpecialCard(Card.TypesOfCards.Skip, Card.ColorsOfCards.Blue),
                        new StandardCard(Card.TypesOfCards.StandardNumber, Card.ColorsOfCards.Blue, 5)
                )
        );
        assertTrue(
                game.validateAction(
                        new StandardCard(Card.TypesOfCards.StandardNumber, Card.ColorsOfCards.Red, 5),
                        new StandardCard(Card.TypesOfCards.StandardNumber, Card.ColorsOfCards.Blue, 5)
                )
        );
        assertTrue(
                game.validateAction(
                        new StandardCard(Card.TypesOfCards.StandardNumber, Card.ColorsOfCards.Red, 5),
                        new SpecialCard(Card.TypesOfCards.Skip, Card.ColorsOfCards.Red)
                )
        );
        assertFalse(
                game.validateAction(
                        new StandardCard(Card.TypesOfCards.StandardNumber, Card.ColorsOfCards.Red, 5),
                        new StandardCard(Card.TypesOfCards.StandardNumber, Card.ColorsOfCards.Blue, 7)
                )
        );

        assertTrue(
                game.validateAction(
                        new StandardCard(Card.TypesOfCards.StandardNumber, Card.ColorsOfCards.Red, 5),
                        new StandardCard(Card.TypesOfCards.StandardNumber, Card.ColorsOfCards.Red, 7)
                )
        );





    }
}