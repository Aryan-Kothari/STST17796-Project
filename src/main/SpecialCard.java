package main;

public class SpecialCard extends Card {

    public SpecialCard(TypesOfCards type, ColorsOfCards color) {
        super(type, color);
        this.state = "active";

    }

    public void flipCardState() {
        this.state = null;
    }


    @Override
    public String toString() {
        return String.format("[%s, %s]", this.cardType, this.color);
    }
}
