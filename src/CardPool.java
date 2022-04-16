/**
 * This class will manage all the cards that are in the junk card pool and the drawable card pool.
 *
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */

import java.util.ArrayList;
import java.util.Collections;

public class CardPool {
    private final ArrayList<Card> junk = new ArrayList<Card>();
    private final ArrayList<Card> drawable = new ArrayList<Card>();

    public CardPool() {

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

    public void showCards(){
        // displays the cards in both arraylists
        System.out.println(">>>>>>>>>> JUNK <<<<<<<<<<\n");

        junk.forEach(System.out::println);
        System.out.println("\n");

        System.out.println(">>>>>>>>>> DRAWABLE <<<<<<<<<<\n");
        drawable.forEach(System.out::println);


    }

    public Card drawCard() {
        // gets the top most card then removes it from the arraylist.
        if (this.drawable.size() == 0){ // if drawable pile is empty
            this.reShuffle();
        }

        Card drawnCard = this.drawable.get(0);
        this.drawable.remove(0);
        return drawnCard;
    }

    public void randomizeDrawableCardPool() {
        // randomize the arraylist of drawable cards
        Collections.shuffle(this.drawable);
    }

    public void moveToJunk(Card card) {
        // when a card that is currently in play is used, it will be moved to the junk pile
        // and will then be the top most card.
        this.junk.add(card);


    }

    public Card getTopJunkCard() {
        return this.junk.get(this.junk.size() - 1);
    }

    public int drawCount(){
        return this.drawable.size();
    }
    public int junkCount(){
        return this.drawable.size();
    }

    public void reShuffle(){

        this.drawable.addAll(this.junk); // add all junk cards back to the drawable pool
//        this.junk.removeAll(this.junk); // empty the junk arraylist
        for (Card junkCard : this.junk){
            this.junk.remove(junkCard);
        }

        this.randomizeDrawableCardPool();

        // move top drawable card to junk pile
        this.junk.add(this.drawable.get(0));
        this.drawable.remove(0); // delete from drawable
    }

}
