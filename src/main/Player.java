package main;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */
public abstract class Player {

    private String name; //the unique name for this player
    public GroupOfCards cards;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public abstract GroupOfCards getCardGroup();

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */

    public String toString() {
        return this.getName();
    }


    public abstract void addCard(Card newCard);

    public abstract void removeCard(int cardIndexToRemove);

    public abstract boolean hasCards();

}

