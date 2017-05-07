package org.test.cardshark;

import org.junit.Test;

/**
 * Created by wprice on 4/21/17.
 */
public class SuitTest {


  @Test
  public void testSuit() {
    Suit suit = CardSharkTestHelper.random(Suit.class);
    CardSharkTestHelper.typeComplies(suit);
  }
}
