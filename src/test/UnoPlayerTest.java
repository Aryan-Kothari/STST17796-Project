package test;



import main.Card;
import main.GroupOfCards;
import main.SpecialCard;
import main.UnoPlayer;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UnoPlayerTest {

    @org.junit.Test
    public void testGetCardGroup() {
        System.out.println("testGetCardGroup");
        UnoPlayer player = new UnoPlayer("test player");
        if (player.getCardGroup() == null){ // check if the cards property was initialized.
            fail();
        }


    }

    @org.junit.Test
    public void testAddCard() {
        System.out.println("testAddCard");
        UnoPlayer player = new UnoPlayer("test player");

        Card cardToAdd = new SpecialCard(Card.TypesOfCards.Draw, Card.ColorsOfCards.Blue);

        player.addCard(cardToAdd);
        assertEquals(cardToAdd, player.getCardGroup().cards.get(0)); // the player has no cards,
        // so we can check if the card we just created has been added successfully.

    }

    @org.junit.Test
    public void testRemoveCard() {
        System.out.println("testRemoveCard");
        UnoPlayer player = new UnoPlayer("test player");

        Card cardToAdd = new SpecialCard(Card.TypesOfCards.Draw, Card.ColorsOfCards.Blue);
        player.addCard(cardToAdd);
        player.removeCard(0);
        assertEquals(0, player.getCardGroup().cards.size());


    }

    @org.junit.Test
    public void testHasCards() {
        System.out.println("testHasCards");
        UnoPlayer player = new UnoPlayer("test player");

        Card cardToAdd = new SpecialCard(Card.TypesOfCards.Draw, Card.ColorsOfCards.Blue);
        player.addCard(cardToAdd);

        assertTrue(player.hasCards());
        player.removeCard(0);
        assertFalse(player.hasCards());

    }
}