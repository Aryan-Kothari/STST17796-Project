package main;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Requires Java 16
 *@author Aryan Kothari, Jinal Jadav & Amaan Sheikh; March 2021
 *
 */

public class Main {
    public static void main(String[] args) throws Exception {
        Uno game = new Uno(); // Uno
        Scanner scanner = new Scanner(System.in);

        ArrayList<Player> players_to_add = new ArrayList<Player>();
        while (true){ // register player loop
            System.out.println("Options:\n" +
                    "1. Add Player\n" +
                    "2. Start Game\n" +
                    "> > > ");
            String selection = scanner.next();
            if (Objects.equals(selection, "1")){
                System.out.println("Enter the players name > > > ");
                players_to_add.add(new UnoPlayer(scanner.next()));
            }else if (Objects.equals(selection, "2")){
                break; // starts game
            }
        }

        game.setPlayers(players_to_add); // comment out to use auto generated players.
//        game.setPlayers(generate_players(3)); // uncomment to use auto generated players.
        game.dealStartingCards();

        game.play();

    }


    /**
     * Generates sample players
     * @param amount number of players to make
     * @return arraylist of generated players
     */
    public static ArrayList<Player> generate_players(int amount){
        // for testing

        ArrayList<Player> generated_players = new ArrayList<Player>();
        for (int i = 0; i < amount; i++) {
            generated_players.add(new UnoPlayer("Player #" + (i + 1)));
        }
        return generated_players;
    }
}
