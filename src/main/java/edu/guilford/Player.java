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
    public void knock() {
        this.knocked = true;
    }

    /**
     * Draws a card from the top of either the stockpile which is a Queue or the discard pile which is a Stack,
     * and adds it to the players hand.
     * 
     * @param stockpile A boolean to represent if the card should be drawn from the stockpile or discard pile.
     * @param stockpile The stockpile to draw from.
     * @param discardPile The discard pile to draw from.
     * @return The card drawn from the stockpile or discard pile.
     */
    public Card draw(boolean fromStockpile, Stockpile stockpile, DiscardPile discardPile) {
        if (fromStockpile) {
            //TODO: make sure works with stockpile
            Card card = stockpile.remove();
            hand.addCard(card);
            return card;
        } else {
            Card card = discardPile.draw();
            hand.addCard(card);
            return card;
        }
    }

    /**
     * Removes a card of specified rank and suit from the player's hand
     * and places it on the top of the discard pile or the bottom of the stockpile.
     * 
     * @param card The card to be discarded.
     * @param toDiscard A boolean to represent if the card should be discarded or added to the stockpile.
     * @param discardPile The discard pile to discard from.
     * @param stockpile The stockpile to add to.
     */
    public void discard(Card card, boolean toDiscard, DiscardPile discardPile, Stockpile stockpile) {
        if (toDiscard) {
            discardPile.push(card);
        } else {
            stockpile.push(card);
        }
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

    /**
     * This method plays the computer player's turn. It impements methods that....  
     */
    public void autoPlayerTurn(DiscardPile discardPile, Stockpile stockpile) {
        // Check if player should knock
        if (!knocked && getTotalValue() >= 27) {
            knock();
        } else if (drawChoice(discardPile)) {
            draw(true, stockpile, discardPile); // Draw from discard pile
            discard(discardChoice(), true, discardPile, stockpile); // Discard card to either discard pile or stockpile
        } else {
            draw(false, stockpile, discardPile); // Draw from stockpile
            discard(discardChoice(), true, discardPile, stockpile); // Discard card to either discard pile or stockpile
        }
    }
    
    /**
     * Determines whether the player should draw from the stockpile or the discard pile.
     * If the top card of the discard pile matches the suit of any card in the player's hand,
     * the player will choose to draw from the discard pile. Otherwise, they draw from the stockpile.
     *
     * @param discardPile The discard pile to inspect.
     * @return true if the player should draw from the Discard pile, false if from the stockpile.
     */
    public boolean drawChoice(DiscardPile discardPile) {
        Card topCard = discardPile.peek();
        for (Card card : hand.getHand()) {
            if (card.getSuit() == topCard.getSuit()) {
                return true; // Draw from discard pile
            }
        }
        return false; // Draw from stockpile
    }

    /**
     * Selects the card with the lowest rank fo discard.
     * This method is a placeholder for more complex decision making.
     * Will build out after there is a running version.
     * 
     * @return The card to discard.
     */
    public Card discardChoice() {
        Card lowest = hand.getHand().get(0);
        for (Card card : hand.getHand()) {
            if (card.compareTo(lowest) < 0) {
                lowest = card;
            }
        }
        return lowest;
    }

    /**
     * Determines whether the player should knock. If the value of the
     * player's hand is greater than or equal to 27 returns true.
     *
     * @return true if the player should knock, false otherwise.
     */
    public void willKnock() {
        if (!knocked && getTotalValue() >= 27) {
            knock();
        }
    }

}
