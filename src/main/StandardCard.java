package main;

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

    @Override
    public void flipCardState() {

    }
}
