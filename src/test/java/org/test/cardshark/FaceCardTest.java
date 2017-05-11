package org.test.cardshark;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * Created by wprice on 5/10/17.
 */
public class FaceCardTest {

  @Test(expected = IndexOutOfBoundsException.class)
  public void testFaceCardMin() {
    List<Integer> values = Arrays.stream(FaceCardType.values()).map(faceCardType -> faceCardType.getValue()).collect(
        Collectors.toList());
    FaceCardType.valueOf(values.get(0) - 1);
  }

}
