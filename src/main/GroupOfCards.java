package main;

import java.util.ArrayList;

/**
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    public final ArrayList<Card> cards = new ArrayList<Card>();

    public GroupOfCards() {

    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }


    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return this.cards.size();
    }


    /**
     * Will remove a card at the given index. Returns the card that was removed to be used elsewhere.
     *
     * @param index index of the card to be removed
     * @return the card that was removed.
     */
    public Card removeCard(int index) {
        // returns card so that it can be used as the new top junk card
        Card return_card = this.cards.get(index);
        this.cards.remove(index);
        return return_card;

    }


    /**
     * Add card to the card group.
     *
     * @param newCard the card to be added
     */
    public void addCard(Card newCard) {
        this.cards.add(newCard);
    }

}//end class
