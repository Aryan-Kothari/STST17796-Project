package main;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Extends Game class
 * Used to implement Uno.
 * @author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 */
public class Uno extends Game {

    public Uno() {
        super("Uno!"); // init game with name Uno.
        this.card_pool = new CardPool(); // Create card pool using CardPool class
        this.players = new ArrayList<Player>(); // Store arraylist of players.
        this.scanner = new Scanner(System.in); // Scanner to take user input
    }


    /**
     * Deal 7 cards per player from the drawable card pool.
     * @throws Exception if too many or not enough players
     */
    public void dealStartingCards() throws Exception {
        // start dealing cards
        // for each player, give them 7 cards

        if (this.players.size() < 2) {
            throw new Exception("Not enough players");
        } else if (this.players.size() > 10) {
            throw new Exception("Too many players.");
        }

        for (Player player : this.players) {
            // take 7 cards out of the drawable pile
            for (int i = 0; i < 7; i++) {
                player.cards.addCard(this.card_pool.drawCard());
            }
        }


    }

    /**
     * Start game loop
     */
    @Override
    public void play() {


        while (this.checkWin()) { // loops and checks if there is a winner every round


            // start cycling turns;
            for (Player player : this.players) {
                // do players turn

                System.out.println(player.getName() + "'s Turn!"); // show whos turn it is
                System.out.println("Your cards: "); // display this players cards
                for (int i = 0; i < player.cards.getCards().size(); i++) {
                    System.out.println(i + ": " + player.cards.getCards().get(i)); // i is the index of their card in the GroupOfCards for each player.
                }
                System.out.println("\n");

                System.out.println("Discard: " + this.card_pool.getTopJunkCard()); // show the top card of the junk pile


                while (true) { // functionality to detect skip or draw 2 cards.

                    if (this.card_pool.getTopJunkCard() instanceof SpecialCard) {
                        if (Objects.equals(this.card_pool.getTopJunkCard().state, "active")) { // if this draw 2 card turn has not been used
                            if (this.card_pool.getTopJunkCard().cardType == Card.TypesOfCards.Draw) {
                                System.out.println("Previous turn used DRAW 2 card; " + player.getName() + " has drawn two cards.");
                                player.cards.addCard(this.card_pool.drawCard()); // draws two cards
                                player.cards.addCard(this.card_pool.drawCard());
                                this.card_pool.getTopJunkCard().flipCardState(); // flip the card state so that the next turn does not draw 2 cards.
                            } else {
                                System.out.println("Previous turn used SKIP card. " + player.getName() + "'s turn has been skipped.");
                            }

                            break;
                        }
                    }

                    // if their turn is not skipped due to a special card.
                    System.out.println("Options:\n1. Use a card\n2. Draw a card"); // show options
                    System.out.print("> > > ");
                    String selection = scanner.next();

                    if (Objects.equals(selection, "1")) { // if they want to use a card
                        // use card logic (check if there is a card that can be played).
                        System.out.print("Enter the card you would like to use > > > "); // input
                        String card_selection = scanner.next();

                        if (Integer.parseInt(card_selection) > player.cards.getSize() - 1) { // if this is an invalid card number
                            continue; // ask again
                        } else {
                            // check if that action is valid. if valid -> break. else -> continue
                            // get card

                            Card actionCard = player.cards.getCards().get(Integer.parseInt(card_selection)); // get the card they would like to use
                            if (this.validateAction(actionCard, this.card_pool.getTopJunkCard())) { // validate the move
                                // delete card from player card group, move to top of junk card pool.
                                this.card_pool.moveToJunk(player.cards.removeCard(Integer.parseInt(card_selection)));

                                break; // end turn
                            } else {
                                System.out.println("Invalid action. Card color or number do not match.");
                                continue; // if the move is invalid, we can ask them to make another play.
                            }


                        }


                    } else if (Objects.equals(selection, "2")) {
                        // draw card logic
                        player.cards.addCard(this.card_pool.drawCard()); // add card to their group of cards, remove card from draw pool.
                        break; // next turn
                    } else {
                        // if they didn't enter a valid option
                        System.out.println("Invalid Entry");
                        // continue loop till they do something right


                    }
                }
                // check win

                if (!player.hasCards()) {
                    // show winner screen
                    this.declareWinner(player);
                    break; // if the current player has 0 cards, break out of the turn loop, and return to the game loop.
                }
            }
        }
    }

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    @Override
    public void declareWinner(Player player) {
        System.out.println(player.getName() + " wins!");
    }


    /**
     * Checks all the players to see if anyone has 0 cards.
     * If a player has 0 cards, they have won and the game is over. This is checked on every turn.
     * @return boolean if a player has won
     */
    @Override
    public boolean checkWin() {

        for (Player player : this.players) { // for each player
            if (!player.hasCards()) { // if a player has 0 cards
                return false; // return false and end game
            }
        }
        return true; // if there are no players at 0 cards, then continue game return true.
    }

    /**
     * Takes two cards, and compares them to check if the move is a valid move. Either the number or color must match.
     * @param actionCard the card being used
     * @param topJunkCard the top junk card
     * @return boolean if valid play.
     */
    public boolean validateAction(Card actionCard, Card topJunkCard) {
        if (actionCard instanceof StandardCard && topJunkCard instanceof StandardCard) { // if both cards are number cards, we can compare the number and color for a match
            if (actionCard.color == topJunkCard.color) {
                return true;
            }

            if (actionCard.number == topJunkCard.number) {
                return true;
            }
            return false;
        }

        if (actionCard instanceof SpecialCard || topJunkCard instanceof SpecialCard) {
            if (actionCard.color == topJunkCard.color) {
                return true;
            }
            return false;
        }
        return false;


    }

}//end class
