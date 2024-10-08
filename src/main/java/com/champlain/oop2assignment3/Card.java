package com.champlain.oop2assignment3;

/**
 * Represents a playing card with a specific suit and rank.
 * @implNote This class is immutable, meaning that once a card is created, its suit and rank cannot be changed.
 */
public class Card implements Comparable<Card> {
    /**
     * The suit of this card (e.g., Hearts, Diamonds, Clubs, Spades).
     */
    private final Suit aSuit;

    /**
     * The rank of this card (e.g., Ace, 2, 3, ..., King).
     */
    private final Rank aRank;

    /**
     * Constructs a new Card with the specified rank and suit.
     *
     * @param pRank the rank of the card (e.g., Ace, 2, 3, ..., King)
     * @param pSuit the suit of the card (e.g., Hearts, Diamonds, Clubs, Spades)
     */
    public Card (Rank pRank, Suit pSuit) {
        this.aRank = pRank;
        this.aSuit = pSuit;
    }

    /**
     * Returns the rank of this card.
     *
     * @return the rank of the card
     */
    public Rank getRank() {
        return this.aRank;
    }

    /**
     * Returns the suit of this card.
     *
     * @return the suit of the card
     */
    public Suit getSuit() {
        return this.aSuit;
    }

    /**
     * Returns a string representation of this card.
     *
     * @return a string in the format "Rank of Suit" (e.g., "Ace of Hearts")
     */
    @Override
    public String toString() {
        return this.getRank() + " of " + this.getSuit();
    }
    @Override
    public int compareTo(Card other) {

        // Compare by Rank first
        int suitCompare = this.aRank.compareTo(other.aRank);
        if (suitCompare != 0) {
            return suitCompare;
        }
        // If the Rank is the same, compare by suits
        return this.aSuit.compareTo(other.aSuit);
    }
    /**
     * Compares two cards based on their suit first, then by rank if suits are equal.
     *
     * @param other the other card to compare to
     * @return a negative integer, zero, or a positive integer as this card is less than, equal to, or greater than the specified card
     */
    public int compareBySuitFirst(Card other) {
        // Compare by Suit first
        int suitCompare = this.aSuit.compareTo(other.aSuit);
        if (suitCompare != 0) {
            return suitCompare;
        }
        // If the Suit is the same, compare by ranks
        return this.aRank.compareTo(other.aRank);
    }
}
