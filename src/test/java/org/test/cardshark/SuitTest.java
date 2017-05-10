package org.test.cardshark;

import org.junit.Test;

/**
 * Created by wprice on 5/10/17.
 */
public class SuitTest {

  @Test(expected = IndexOutOfBoundsException.class)
  public void testInvalidSuit() {
    Suit suit = Suit.valueOf(Suit.values().length + 1);
  }

}
