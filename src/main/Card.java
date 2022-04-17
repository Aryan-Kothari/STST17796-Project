package main;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */
public abstract class Card {
    public String state;

    public abstract void flipCardState();

    //default modifier for child classes
    public enum TypesOfCards {StandardNumber, Skip, Draw}

    public enum ColorsOfCards {Blue, Green, Red, Yellow}

    public ColorsOfCards color;
    public int number;
    public TypesOfCards cardType;

    public Card(TypesOfCards type, ColorsOfCards color, int number) {

        this.cardType = type;
        this.color = color;
        this.number = number;
    }

    public Card(TypesOfCards type, ColorsOfCards color){

        this.cardType = type;
        this.color = color;

    }


    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public abstract String toString();

}

