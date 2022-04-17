package test;

import main.Card;
import main.CardPool;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardPoolTest {

    @org.junit.Test
    public void testGetPile() {
        System.out.println("testGetPile");
        CardPool cardPool = new CardPool();
        assertEquals(95, cardPool.getPile("drawable").size());
        assertEquals(1, cardPool.getPile("junk").size());

    }

    @org.junit.Test
    public void testDrawCard() {
        System.out.println("testDrawCard");
        CardPool cardPool = new CardPool();
        int initial_drawable_pile_size = cardPool.getPile("drawable").size();
        Card drawn_card = cardPool.drawCard();
        if (!(cardPool.getPile("drawable").size() < initial_drawable_pile_size)){ // check if the new pile is smaller
            fail();
        }

    }

    @org.junit.Test
    public void testRandomizeDrawableCardPool() {
        CardPool cardPool = new CardPool();
        ArrayList<Card> original = new ArrayList<Card>(cardPool.getPile("drawable")); // create a copy of the arraylist
        cardPool.randomizeDrawableCardPool();
        ArrayList<Card> afterShuffle = cardPool.getPile("drawable");
        assertNotEquals(original, afterShuffle);
    }

    @org.junit.Test
    public void testMoveToJunk() {
        CardPool cardPool = new CardPool();
        int initial_junk_pile_size = cardPool.junkCount();
        cardPool.moveToJunk(cardPool.drawCard()); // grab a card and put it in the junk pile
        assertNotEquals(initial_junk_pile_size, cardPool.junkCount());


    }

    @org.junit.Test
    public void testGetTopJunkCard() {
        CardPool cardPool = new CardPool();
        assertNotEquals(cardPool.getTopJunkCard(), null);
    }

    @org.junit.Test
    public void testDrawCount() {
        System.out.println("testDrawCount");
        int expResult = 95;
        int card_count =  new CardPool().drawCount();
        assertEquals(expResult, card_count);
    }

    @org.junit.Test
    public void testJunkCount() {
        System.out.println("testJunkCount");
        CardPool cardPool = new CardPool();
        assertEquals(1, cardPool.junkCount()); // the junk pile should only have 1 card in it at the start of the game.
    }

    @org.junit.Test
    public void testReShuffle() {
        System.out.println("testReShuffle");
        CardPool cardPool = new CardPool();

        for (int i = 0; i < 5; i++){

            cardPool.moveToJunk(cardPool.drawCard()); // take from drawable, move to junk

        }
        cardPool.reShuffle();
        assertEquals(95, cardPool.drawCount());
        assertEquals(1, cardPool.junkCount());

    }
}