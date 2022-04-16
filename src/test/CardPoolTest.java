package test;

import main.CardPool;

import static org.junit.Assert.*;

public class CardPoolTest {

    @org.junit.Test
    public void testShowCards() {
    }

    @org.junit.Test
    public void testDrawCard() {
    }

    @org.junit.Test
    public void testRandomizeDrawableCardPool() {
    }

    @org.junit.Test
    public void testMoveToJunk() {
    }

    @org.junit.Test
    public void testGetTopJunkCard() {
    }

    @org.junit.Test
    public void testDrawCount() {
        System.out.println("testDrawCount");
        int expResult = 94;
        int card_count =  new CardPool().drawCount();
        System.out.println(card_count);
        assertEquals(expResult, card_count);
    }

    @org.junit.Test
    public void testJunkCount() {
        System.out.println("testJunkCount");
        int expResult = 1;
        int card_count =  new CardPool().junkCount();
        System.out.println(card_count);
        assertEquals(expResult, card_count);
    }

    @org.junit.Test
    public void testReShuffle() {
    }
}