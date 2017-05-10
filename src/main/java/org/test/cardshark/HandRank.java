package org.test.cardshark;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by wprice on 5/9/17.
 */
public enum HandRank {

  HIGH_CARD(0),
  PAIR(1),
  TWO_PAIR(2),
  THREE_OF_A_KIND(3),
  STRAIGHT(4),
  FLUSH(5),
  FULL_HOUSE(6),
  FOUR_OF_A_KIND(7),
  STRAIGHT_FLUSH(8),
  ROYAL_FLUSH(9);

  private final int value;

  private HandRank(int value) {
    this.value = value;
  }

  public static HandRank valueOf(int value) {
    return Arrays.stream(HandRank.values()).filter(rank -> rank.value == value).collect(
        Collectors.toList()).get(0);
  }
}
