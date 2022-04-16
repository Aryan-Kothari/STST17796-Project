package main;

import java.util.ArrayList;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *@author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 *
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

    public Card removeCard(int index){
        // returns card so it can be used as the new top junk card
        Card return_card = this.cards.get(index);
        this.cards.remove(index);
        return return_card;

    }


    public void addCard(Card newCard){
        this.cards.add(newCard);
    }

}//end class
