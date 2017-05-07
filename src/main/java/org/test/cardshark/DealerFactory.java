package org.test.cardshark;

import org.test.cardshark.impl.DealerImpl;

/**
 * Created by wprice on 4/21/17.
 */
public class DealerFactory {

  private static final int DEFAULT_DECK_COUNT = 1;
  private static final boolean SHUFFLE = true;


  public static Dealer createDealer() {
    return createDealer(DEFAULT_DECK_COUNT);
  }
  public static Dealer createDealer(int deckCount) {
   return createDealer(deckCount, SHUFFLE);
  }
  public static Dealer createDealer(int deckCount, boolean shuffle) {
    return new DealerImpl(deckCount, shuffle);
  }

}
