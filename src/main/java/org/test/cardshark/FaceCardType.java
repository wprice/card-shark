package org.test.cardshark;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by wprice on 5/7/17.
 */
public enum FaceCardType {

  ACE(1),
  JACK(11),
  QUEEN(12),
  KING(13);

  private final int value;

  private FaceCardType(int value) {
    this.value = value;
  }

  public static FaceCardType valueOf(int value) {
    return Arrays.stream(FaceCardType.values()).filter(faceCardType -> faceCardType.value == value).collect(
        Collectors.toList()).get(0);
  }

}
