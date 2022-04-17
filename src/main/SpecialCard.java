package main;

/**
 * Extends Card class. Creates a Special card; either draw or skip card. This card has no number value, so the number property is not initialized.
 * Also contains a state property to track if the card has been used in the junk pile.
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */
public class SpecialCard extends Card {

    public SpecialCard(TypesOfCards type, ColorsOfCards color) {
        super(type, color);
        this.state = "active"; // init state property

    }

    /**
     * When a draw or skip card is used, they will start with a state of active until the next turn.
     * Once the next turn is completed, the draw or skip card will have their state changed, so that the following turn is not affected by the card.
     */
    public void flipCardState() {
        this.state = null;
    }


    @Override
    public String toString() {
        return String.format("[%s, %s]", this.cardType, this.color);
    }
}
