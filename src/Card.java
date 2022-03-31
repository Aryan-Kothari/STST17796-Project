
/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */
public abstract class Card {
    //default modifier for child classes
    enum TypesOfCards {Number, Reverse, Skip, Draw, Black, Blank}
    public String color;
    public int number;
    public TypesOfCards cardType;




    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public abstract String toString();




}
