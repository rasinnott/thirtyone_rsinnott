package edu.guilford;

/**
 * This is a class to represent a player of the game. I has attributes for the name of the player,
 * the player's hand, and a boolean to identify if te player has knocked.It contains methods to for the actions a player can take durring the game.
 */
public class Player {

    /**
     * A String to represent the name of the player.
     */
    private String name;

    /**
     * A hand of cards that the player has.
     */
    private Hand hand;

    /**
     * A boolean to represent if the player has knocked.
     */
    private boolean knocked;

    /**
     * A default constructor to create a player with a name and an empty hand
     * and knocked set to false..
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.knocked = false;
    }

    /**
     * Gets the name of the player.
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the hand of the player.
     * @return The hand of the player.
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Gets the knocked boolean of the player.
     * @return The knocked boolean of the player.
     */
    public boolean getKnocked() {
        return knocked;
    }

    /**
     * Sets the knocked boolean of the player.
     * @param knocked The knocked boolean of the player.
     */
    public void knock(boolean knocked) {
        knocked = true;
    }

    /**
     * Draws a card from the top of either the stockpile which is a Queue or the discard pile which is a Stack,
     * and adds it to the players hand.
     * 
     * @param stockpile A boolean to represent if the card should be drawn from the stockpile or discard pile.
     * @return The card drawn from the stockpile or discard pile.
     */
    public Card draw(boolean drawFromStockpile) {
        if (drawFromStockpile) {
            //TODO: make sure works with stockpile
            Card card = stockpile.remove();
            hand.addCard(card);
            return card;
        } 
    }

    /**
     * Removes a card of specified rank and suit from the player's hand
     * and places it on the top of the discard pile.
     * 
     * @param The card to be discarded.
     */
    public void discard(Card card) {
        hand.removeCard(card);
        // TODO: make sure works with discard pile
        discardPile.push(new Card(rank, suit));
    }

    /**
     * Gets the total value of the player's hand.
     * 
     * @return The total value of the player's hand.
     */
    public int getTotalValue() {
        return hand.getTotalValue();
    }

    /**
     * toString method to return a string representation of the player's
     * hand, score, and whether or not the player has knocked.
     * 
     * @return A string representation of the player.
     */
    @Override
    public String toString() {
        return name + "'s hand: \n" + hand.toString() +
        "Score: " + getTotalValue() +
        "\nHas knocked: " + knocked;
    }

}
