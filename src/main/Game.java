package main;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */
public abstract class Game {

    private final String name;//the title of the game
    public ArrayList<Player> players;// the players of the game
    public CardPool card_pool;
    protected Scanner scanner;

    public Game(String name) {
        this.name = name;

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner(Player player);

    public abstract void dealStartingCards() throws Exception;

    public abstract boolean checkWin();

    public abstract boolean validateAction(Card actionCard, Card topJunkCard);

}//end class

