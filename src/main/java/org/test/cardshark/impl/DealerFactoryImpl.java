package org.test.cardshark.impl;

import org.test.cardshark.Dealer;
import org.test.cardshark.DealerFactory;

/**
 * Created by wprice on 4/21/17.
 */
public class DealerFactoryImpl implements DealerFactory {

  private static final int DEFAULT_DECK_COUNT = 1;

  @Override
  public Dealer createDealer(int deckCount) {
    Dealer dealer = new DealerImpl();
    return dealer;
  }

  @Override
  public Dealer createDealer() {
    return createDealer(DEFAULT_DECK_COUNT);
  }
}
