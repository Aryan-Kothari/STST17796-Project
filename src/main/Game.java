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

class Uno extends Game {

    public Uno() {
        super("Uno!");
        this.card_pool = new CardPool();
        this.players = new ArrayList<Player>();
        this.scanner = new Scanner(System.in);
    }


    public void dealStartingCards() throws Exception {
        // start dealing cards
        // for each player, give them 7 cards

        if (this.players.size() < 2){
            throw new Exception("Not enough players");
        }else if (this.players.size() > 10){
            throw new Exception("Too many players.");
        }

        for (Player player : this.players){
            // take 7 cards out of the drawable pile
            for (int i = 0; i < 7; i++){
                player.cards.addCard(this.card_pool.drawCard());
            }
        }



    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    @Override
    public void play() {


        while (this.checkWin()) { // loops and checks if there is a winner every round


            // start cycling turns;
            for (Player player : this.players) {
                // do turn

                System.out.println(player.getName() + "'s Turn!");
                System.out.println("Your cards: ");
                for (int i = 0; i < player.cards.getCards().size(); i++){
                    System.out.println(i + ": " + player.cards.getCards().get(i));
                }
                System.out.println("\n");

                System.out.println("Discard: " + this.card_pool.getTopJunkCard());


                while (true){

                    if (this.card_pool.getTopJunkCard() instanceof SpecialCard){
                        if (Objects.equals(this.card_pool.getTopJunkCard().state, "active")){ // if this draw 2 card turn has not been used
                            if (this.card_pool.getTopJunkCard().cardType == Card.TypesOfCards.Draw){
                                System.out.println("Previous turn used DRAW 2 card; " + player.getName() + " has drawn two cards.");
                                player.cards.addCard(this.card_pool.drawCard()); // draws two cards
                                player.cards.addCard(this.card_pool.drawCard());
                                this.card_pool.getTopJunkCard().flipCardState(); // flip the card state so that the next turn does not draw 2 cards.
                            }else{
                                System.out.println("Previous turn used SKIP card. " + player.getName() + "'s turn has been skipped.");
                            }

                            break;
                        }
                    }



                    System.out.println("Options:\n1. Use a card\n2. Draw a card");
                    System.out.print("> > > ");
                    String selection = scanner.next();

                    if (Objects.equals(selection, "1")){
                        // use card logic (check if there is a card that can be played).
                        System.out.print("Enter the card you would like to use > > > ");
                        String card_selection = scanner.next();

                        if (Integer.parseInt(card_selection) > player.cards.getSize() - 1){ // if this is an invalid card number
                            continue; // ask again
                        }else{
                            // check if that action is valid. if valid -> break. else -> continue
                            // get card

                            Card actionCard = player.cards.getCards().get(Integer.parseInt(card_selection));
                            if (this.validateAction(actionCard, this.card_pool.getTopJunkCard())){ // validate the move
                                // delete card from player card group, move to top of junk card pool.
                                this.card_pool.moveToJunk(player.cards.removeCard(Integer.parseInt(card_selection)));

                                break;
                            }else{
                                System.out.println("Invalid action. Card color or number do not match.");
                                continue; // if the move is invalid, we can ask them to make another play.
                            }


                        }




                    }else if (Objects.equals(selection, "2")){
                        // draw card logic
                        player.cards.addCard(this.card_pool.drawCard());
                        break;
                    }else {
                        // if they didn't enter a valid option
                        System.out.println("Invalid Entry");
                        // continue loop till they do something right


                    }
                }
                // check win

                if (!player.hasCards()) {
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
    public boolean checkWin() {

        for (Player player : this.players) { // for each player
            if (!player.hasCards()) { // if a player has 0 cards
                return false; // return false and end game
            }
        }
        return true; // if there are no players at 0 cards, then continue game return true.
    }

    public boolean validateAction(Card actionCard, Card topJunkCard){
        if (actionCard instanceof StandardCard && topJunkCard instanceof StandardCard){ // if both cards are number cards, we can compare the number and color for a match
            if (actionCard.color == topJunkCard.color){
                return true;
            }

            if (actionCard.number == topJunkCard.number){
                return true;
            }
            return false;
        }

        if (actionCard instanceof SpecialCard || topJunkCard instanceof SpecialCard){
            if (actionCard.color == topJunkCard.color){
                return true;
            }
            return false;
        }
        return false;


    }

}