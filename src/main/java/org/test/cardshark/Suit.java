package org.test.cardshark;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by wprice on 4/21/17.
 */
public enum Suit {

  HEART(0),
  DIAMOND(1),
  CLUB(2),
  SPADE(3);

  private final int value;

  private Suit(int value) {
    this.value = value;
  }

  public static Suit valueOf(int value) {
    return Arrays.stream(Suit.values()).filter(suit -> suit.value == value).collect(
        Collectors.toList()).get(0);
  }

  public int getValue() {
    return value;
  }
}
