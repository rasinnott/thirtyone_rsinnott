package edu.guilford;

import java.util.ArrayList;

/**
 * This class represents the game of ThirtyOne. It contains methods to
 * initialize the game,
 * to play the game, and to end the game.
 */
public class Game {

    /**
     * An ArrayList to represent the players in the game.
     */
    private ArrayList<Player> players;

    /**
     * The player that has won the game.
     */
    private Player winner;

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
    private int currentPlayerIndex = 0;

    /**
     * An attribute to flag if anyone has knocked.
     * 
     * @param gameKnocked
     */
    private static boolean gameKnocked = false;

    /**
     * A boolean to represent if the game is over.
     */
    private boolean gameOver = false;

    /**
     * A constructor to create a new game with a specified number of players.
     * 
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

        // Deal three cards to each player
        // TODO: Should probably iterate through players while dealing cards.
        for (Player player : players) {
            player.getHand().addCard(deck.deal());
            player.getHand().addCard(deck.deal());
            player.getHand().addCard(deck.deal());
        }

        // Conssdtruct Stockpile from Deck
        stockpile = new Stockpile(deck);

        // Construct DiscardPile from Stockpile
        discardPile = new DiscardPile(stockpile);

    }

    /**
     * Gets deck.
     * 
     * @return
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Gets stockpile.
     * 
     * @return stockpile
     */
    public Stockpile getStockpile() {
        return stockpile;
    }

    /**
     * Gets discardPile.
     * 
     * @return discardPile
     */
    public DiscardPile getDiscardPile() {
        return discardPile;
    }

    /**
     * Gets the ArrayList of players in the game.
     * 
     * @return The ArrayList of players in the game.
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Gets the current player in the game.
     * 
     * @return The current player in the game.
     */
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    /**
     * A method that checks if any players have knocked
     * andsets the gameKnocked attribute to true.
     */
    public void checkKnocked() {
        for (Player player : players) {
            if (player.getKnocked()) {
                gameKnocked = true;
            }
        }
    }

    /**
     * Returns the gameKnocked attribute.
     * 
     * @return The gameKnocked attribute.
     */
    public static boolean getGameKnocked() {
        return gameKnocked;
    }

    /**
     * Gets the winner of the game.
     * 
     * @return The winner of the game.
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * Sets the winning player of the game.
     * 
     * @param winner The winning player of the game.
     */
    public void setWinner(Player winner) {
        this.winner = winner;
    }

    /**
     * Sets the gameOver attribute to true.
     */
    public void gameOver() {
        gameOver = true;
    }

    /**
     * Resets the game.
     */
    public void reset() {
        gameKnocked = false;
        gameOver = false;
        currentPlayerIndex = 0;
        winner = null;
        for (Player player : players) {
            player.reset();
        }
    }

    /**
     * Full player Turn method. (Computer player's turn)
     * 
     * @param discardPile The discard pile to inspect.
     * @param stockpile   The stockpile to inspect.
     */
    public void playerTurn() {
        Player player = getCurrentPlayer();
        player.autoPlayerTurn(discardPile, stockpile);
        checkKnocked();
        if (gameKnocked) {
            playFinalTurn();
        } else {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    /**
     * Plays the final round after a player has knocked.
     */
    public void playFinalTurn() {
        int totalPlayers = players.size();

        // Each player after the knocking player gets one more turn
        for (int i = 1; i < totalPlayers; i++) {
            players.get(currentPlayerIndex).autoPlayerTurn(discardPile, stockpile);
            currentPlayerIndex = (currentPlayerIndex + 1) % totalPlayers;
        }

        // Determine the winner.
        int highestScore = 0;
        for (Player player : players) {
            int score = player.getHand().getTotalValue();
            if (score > highestScore) {
                setWinner(player);
                highestScore = score;
            }
        }
        gameOver();
    }

    /**
     * Starts new round of the game.
     */
    public void newRound() {
        // Reset to initial game values.
        reset();
        // Build and shuffle new Deck.
        // Build and shuffle Deck
        this.deck = new Deck();
        this.deck.shuffle();
        // Deal three cards to each player.
        for (Player player : players) {
            player.getHand().addCard(deck.deal());
            player.getHand().addCard(deck.deal());
            player.getHand().addCard(deck.deal());
        }
        // Construct Stockpile and DiscardPile.
        this.stockpile = new Stockpile(deck);
        this.discardPile = new DiscardPile(stockpile);
    }

    /**
     * Dsiplays the results of the round.
     */
    public void displayResults() {
        System.out.println("The Winner is: " + winner.getName() + "\nHand: " + winner.getHand() +
        "\nScore: " + winner.getTotalValue());
        System.out.println("GAME OVER");
    }

    /**
     * Plays a round of the game.
     */
    public void playRound() {
        newRound();
        while (!gameKnocked) {
            playerTurn();
            checkKnocked();
            /* for (Player player : players) {
                System.out.println(player.getName() + ": " + player.getHand());
            } */
        }
        displayResults();
    }

}
