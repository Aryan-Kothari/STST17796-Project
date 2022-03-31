/**
 * This class will manage all the cards that are in the junk card pool and the drawable card pool.
 *
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */

import java.util.ArrayList;

public class CardPool {
    private ArrayList<Card> junk;
    private ArrayList<Card> drawable;
    private Card topJunkCard;

    public CardPool(ArrayList<Card> allCards) {
        this.junk = new ArrayList<Card>();
        this.drawable = allCards;
        this.topJunkCard = allCards.get(0); // gets the top most card in the drawable card pool to start the junk pool.
    }

    public Card drawCard() {
        // gets the top most card then removes it from the arraylist.
        return this.drawable.get(0);
    }

    public static void randomizeDrawableCardPool() {
        // randomize the arraylist of drawable cards

    }

    public void moveToJunk(Card card) {
        // when a card that is currently in play is used, it will be moved to the junk pile
        // and will then be the top most card.

    }

    public Card getTopJunkCard() {
        return this.topJunkCard;
    }


}
