package main;

/**
 * Extends Player class. Manages the cards each player has.
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */
public class UnoPlayer extends Player {
    /**
     * Constructor to create player
     * @param name indentifier for the player
     */
    public UnoPlayer(String name) {
        super(name);
        cards = new GroupOfCards(); // init the players card pool
    }

    /**
     * gets the groupofcards for this player
     * @return GroupOfCards
     */
    @Override
    public GroupOfCards getCardGroup() {
        return this.cards;
    }

    /**
     * Adds a card to their groupofcards
     * @param newCard the card that is to be added
     */
    public void addCard(Card newCard) {
        this.cards.cards.add(newCard);
    }

    /**
     * removes a given card from their card pool by index
     * @param cardIndexToRemove the index of the card to be removed.
     */
    public void removeCard(int cardIndexToRemove) {
        this.cards.cards.remove(cardIndexToRemove);
    }

    /**
     * Checks if the player has any cards. Used to check if winner.
     * @return boolean if the player as cards
     */
    public boolean hasCards() {
        return this.cards.cards.size() != 0;
    }


}
