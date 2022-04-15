

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 *
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */
public abstract class Game {

    private final String name;//the title of the game
    public ArrayList<Player> players;// the players of the game
    public CardPool card_pool;

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

    public abstract boolean checkWin();

}//end class

class Uno extends Game{

    public Uno() {
        super("Uno!");
        this.card_pool = new CardPool();
        this.players =  new ArrayList<Player>();

        // start dealing cards

    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    @Override
    public void play() {


        while (this.checkWin()){ // loops and checks if there is a winner every round


            // start cycling turns;
            for (Player player : this.players){
                // do turn

                // check win

                if (!player.hasCards()){
                    break; // if the player has 0 cards, break out of the turn loop, and return to the game loop.
                }

            }



        }
        // show winner screen
        this.declareWinner(new UnoPlayer("Test Win Player"));

    }

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    @Override
    public void declareWinner(Player player) {
        System.out.println(player.getName() + " wins!");
    }

    @Override
    public boolean checkWin(){

        for (Player player : this.players){ // for each player
            if (!player.hasCards()){ // if a player has 0 cards
                return false; // return false and end game
            }
        }
        return true; // if there are no players at 0 cards, then continue game return true.
    }
}