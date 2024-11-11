// Danieli, Gabriel

package TexasHoldEm;

public enum Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

    public int getValue() {
        return this.ordinal();
    }
}
