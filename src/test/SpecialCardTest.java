package test;


import main.Card;
import main.SpecialCard;

import static org.junit.Assert.*;

public class SpecialCardTest {

    @org.junit.Test
    public void testFlipCardState() {
        Card card = new SpecialCard(Card.TypesOfCards.Draw, Card.ColorsOfCards.Blue);
        card.flipCardState();
        assertNull(card.state);

    }
}