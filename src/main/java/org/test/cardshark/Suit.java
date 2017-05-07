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

  public static Suit valueOf(int ordinal) {

    for (Suit suit : Suit.values()) {
      if (suit.ordinal == ordinal) {
        return suit;
      }
    }

    throw new IllegalArgumentException("Unknown suit for value: " + ordinal);
  }

}
