package main;

public class UnoPlayer extends Player {

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */

    public UnoPlayer(String name) {
        super(name);
        cards = new GroupOfCards();
    }

    @Override
    public GroupOfCards getCardGroup() {
        return this.cards;
    }

    public void addCard(Card newCard) {
        this.cards.cards.add(newCard);
    }

    public void removeCard(int cardIndexToRemove) {
        this.cards.cards.remove(cardIndexToRemove);
    }

    public boolean hasCards() {
        return this.cards.cards.size() != 0;
    }


}
