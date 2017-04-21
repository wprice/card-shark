package org.test.cardshark;

/**
 * Created by wprice on 4/21/17.
 */
public enum Suit {

    HEART(0),
    DIAMOND(1),
    CLUB(2),
    SPADE(3);

    private final int ordinal;

    private Suit(int ordinal) {
        this.ordinal = ordinal;
    }
}
