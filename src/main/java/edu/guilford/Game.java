package edu.guilford;

import java.util.ArrayList;

/**
 * This class represents the game of ThirtyOne. It contains methods to initialize the game, 
 * to play the game, and to end the game.
 */
public class Game {

    /**
     * An ArrayList to represent the players in the game.
     */
    private ArrayList<Player> players;

    /**
     * A Stockpile to represent the stockpile of cards.
     */
    private Stockpile stockpile;

    /**
     * A DiscardPile to represent the discard pile of cards.
     */
    private DiscardPile discardPile;

    /**
     * A Deck to represent the deck of cards.
     */
    private Deck deck;

    /**
     * The index in the ArrayList of the current player.
     */
    private int currentPlayerIndex;

    /**
     * A constructor to create a new game with a specified number of players.
     * @param numPlayers The number of players in the game.
     */
    public Game(int numPlayers) {
        // Build and shuffle Deck
        this.deck = new Deck();
        this.deck.shuffle();
        
        // Create an ArrayList of Players and set the current player index to 0
        this.players = new ArrayList<Player>();
        for (int i = 0; i < numPlayers; i++) {
            this.players.add(new Player("Player " + (i + 1)));
        }
        this.currentPlayerIndex = 0;

        // Deal three cards to each player
        for (Player player : players) {
            player.draw(true, stockpile, discardPile);
            player.draw(false, stockpile, discardPile);
            player.draw(false, stockpile, discardPile);
        }

        // Conssdtruct Stockpile from Deck
        stockpile = new Stockpile(deck);

        // Construct DiscardPile from Stockpile
        discardPile = new DiscardPile(stockpile);

        
    }

}
     