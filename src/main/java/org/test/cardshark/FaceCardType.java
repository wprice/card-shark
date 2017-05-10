package org.test.cardshark;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by wprice on 5/7/17.
 */
public enum FaceCardType {

  JACK(11),
  QUEEN(12),
  KING(13),
  ACE(14);

  private final int value;

  private FaceCardType(int value) {
    this.value = value;
  }

  public static FaceCardType valueOf(int value) {
    return Arrays.stream(FaceCardType.values()).filter(faceCardType -> faceCardType.value == value).collect(
        Collectors.toList()).get(0);
  }
  public static boolean isFaceCard(int value) {
    return Arrays.stream(values()).filter(faceCardType -> faceCardType.value == value).collect(Collectors.toList()).size() > 0;
  }
  public static boolean isFaceCard(final Card card) {
    return isFaceCard(card.getValue());
  }
  public int getValue() {
    return this.value;
  }
}
