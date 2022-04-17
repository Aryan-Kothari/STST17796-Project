package test;

import main.Card;
import main.GroupOfCards;
import main.StandardCard;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GroupOfCardsTest {

    public GroupOfCards cardGroup;

    @Before
    public void setUp() throws Exception {
        this.cardGroup = new GroupOfCards();
    }

    @org.junit.Test
    public void testGetCards() {
        System.out.println("testGetCards");
        this.cardGroup.addCard(new StandardCard(Card.TypesOfCards.StandardNumber, Card.ColorsOfCards.Blue, 5));
        if (!(this.cardGroup.cards instanceof ArrayList<Card>)) {
            fail();
        }
    }

    @org.junit.Test
    public void testGetSize() {
        System.out.println("testGetSize");
        assertEquals(this.cardGroup.cards.size(), this.cardGroup.getSize());
    }

    @org.junit.Test
    public void testRemoveCard() {
        System.out.println("testRemoveCard");
        this.cardGroup.addCard(new StandardCard(Card.TypesOfCards.StandardNumber, Card.ColorsOfCards.Blue, 5));
        ArrayList<Card> original_cards = new ArrayList<Card>(this.cardGroup.getCards());
        this.cardGroup.removeCard(0);
        assertNotEquals(original_cards, this.cardGroup.getCards());

    }

    @org.junit.Test
    public void testAddCard() {
        System.out.println("testAddCard");
        ArrayList<Card> original_cards = new ArrayList<Card>(this.cardGroup.getCards());
        this.cardGroup.addCard(new StandardCard(Card.TypesOfCards.StandardNumber, Card.ColorsOfCards.Blue, 5));
        assertNotEquals(original_cards, this.cardGroup.getCards());
    }
}