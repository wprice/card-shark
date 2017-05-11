package org.test.cardshark;

import org.junit.Test;

/**
 * Created by wprice on 5/10/17.
 */
public class SuitTest {

  @Test(expected = IndexOutOfBoundsException.class)
  public void testInvalidSuitMax() {
    Suit.valueOf(Suit.values().length + 1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testInvalidSuitMin() {
    Suit.valueOf(-1);
  }
}
