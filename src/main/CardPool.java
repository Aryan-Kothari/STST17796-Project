package main;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * This class will manage all the cards that are in the junk card pool and the drawable card pool.
 *
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */

public class CardPool {
    private final ArrayList<Card> junk = new ArrayList<Card>(); // arraylist to hold junk pile
    private final ArrayList<Card> drawable = new ArrayList<Card>(); // arraylist to hold drawable pile

    public CardPool() {
        // Creates all the cards in the deck
        // add two of each card at value i. Total cards should be 76

        for (Card.ColorsOfCards color : Card.ColorsOfCards.values()){ // for each color of card
            // standard number cards
            for (int i = 0; i < 10; i++){ // 0 -> 9 cards
                // add two
                this.drawable.add(new StandardCard(Card.TypesOfCards.StandardNumber, color, i));
                this.drawable.add(new StandardCard(Card.TypesOfCards.StandardNumber, color, i));

            }
             // add two of each special card for this color.
            this.drawable.add(new SpecialCard(Card.TypesOfCards.Skip, color));
            this.drawable.add(new SpecialCard(Card.TypesOfCards.Skip, color));

            this.drawable.add(new SpecialCard(Card.TypesOfCards.Draw, color));
            this.drawable.add(new SpecialCard(Card.TypesOfCards.Draw, color));



        }

        // randomize drawable pile
        this.randomizeDrawableCardPool();

        // move top drawable card to junk pile
        this.junk.add(this.drawable.get(0));
        this.drawable.remove(0); // delete from drawable



    }

    /**
     * Gets either the drawable or junk arraylist
     * @param pile the pile that is being accessed.
     * @return arraylist of the pile requested
     */
    public ArrayList<Card> getPile(String pile){
        // displays the cards in both arraylists
        if (Objects.equals(pile, "drawable")){
            return this.drawable;
        }else {
            return this.junk;
        }


    }

    /**
     * Takes a card from the top of the drawable arraylist.
     * @return the card that is drawn
     */
    public Card drawCard() {
        // gets the top most card then removes it from the arraylist.
        if (this.drawable.size() == 0){ // if drawable pile is empty
            this.reShuffle(); // take all the junk cards and reshuffle them into the drawable pile.
        }

        Card drawnCard = this.drawable.get(0); // save the card that has been drawn
        this.drawable.remove(0); // remove the drawn card from the arraylist
        return drawnCard; // return that card to be used in the main code.
    }

    /**
     * randomize the arraylist of drawable cards
     */
    public void randomizeDrawableCardPool() {
        // randomize the arraylist of drawable cards
        Collections.shuffle(this.drawable);
    }

    /**
     * Moves a given card to the junk pile. This will be set to the top junk card.
     * @param card the card to be moved to the junk pile.
     */
    public void moveToJunk(Card card) {
        // when a card that is currently in play is used, it will be moved to the junk pile
        // and will then be the top most card.
        this.junk.add(card);


    }

    /**
     * gets the top junk Card.
     * @return the last card in the junk pile; top junk card
     */
    public Card getTopJunkCard() {
        return this.junk.get(this.junk.size() - 1);
    }

    /**
     * Returns the number of cards in the drawable pile
     * @return size of the drawable pile
     */
    public int drawCount(){
        return this.drawable.size();
    }
    /**
     * Returns the number of cards in the junk pile
     * @return size of the junk pile
     */
    public int junkCount(){
        return this.junk.size();
    }


    /**
     * takes all the cards from the junk pile, adds them to the drawable pile, empties the junk pile, and randomizes the drawable pile.
     */
    public void reShuffle(){

        this.drawable.addAll(this.junk); // add all junk cards back to the drawable pool
        this.junk.clear();

        this.randomizeDrawableCardPool();

        // move top drawable card to junk pile
        this.junk.add(this.drawable.get(0));
        this.drawable.remove(0); // delete from drawable
    }

}
