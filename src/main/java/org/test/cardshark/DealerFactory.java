package org.test.cardshark;

/**
 * Created by wprice on 4/21/17.
 */
public interface DealerFactory {

  Dealer createDealer(int deckCount);

  Dealer createDealer();
}
