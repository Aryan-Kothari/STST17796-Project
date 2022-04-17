package main;

/**
 * Extends Card class. Used to make a standard card, which contains a number attribute, and no state attribute.
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */
public class StandardCard extends Card {

    public StandardCard(TypesOfCards type, ColorsOfCards color, int number) {
        super(type, color, number);
    }

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */


    @Override
    public String toString() {
        return String.format("[%s, %s]", this.number, this.color);
    }

    /**
     * The implementation of this function is not required for this sub class.
     */
    @Override
    public void flipCardState() {

    }
}
