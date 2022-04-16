package main;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Uno game = new Uno();

        game.setPlayers(generate_players(2));
        game.dealStartingCards();

        game.play();

    }





    public static ArrayList<Player> generate_players(int amount){
        // for testing

        ArrayList<Player> generated_players = new ArrayList<Player>();
        for (int i = 0; i < amount; i++) {
            generated_players.add(new UnoPlayer("Player #" + (i + 1)));
        }
        return generated_players;
    }
}
