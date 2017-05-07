package org.test.cardshark;

import org.junit.Assert;
import org.junit.Test;
import org.test.cardshark.impl.DealerFactoryImpl;
import org.test.cardshark.impl.DealerImpl;

/**
 * Created by wprice on 4/21/17.
 */
public class DealerTest {

  @Test
  public void testOrderedDeck() {
    Dealer d = new DealerImpl();

  }

  @Test
  public void testDealerFactory() {
    DealerFactory factory = new DealerFactoryImpl();
    Dealer dealer = factory.createDealer(1);
    Assert.assertNotNull(dealer);
    Assert.assertNotEquals(dealer, factory.createDealer());
  }
}
