package test;


import main.Card;
import main.SpecialCard;

import static org.junit.Assert.*;

/**
 * Requires JUnit4 & Java 16
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */

public class SpecialCardTest {

    @org.junit.Test
    public void testFlipCardState() {
        Card card = new SpecialCard(Card.TypesOfCards.Draw, Card.ColorsOfCards.Blue);
        card.flipCardState();
        assertNull(card.state);

    }
}