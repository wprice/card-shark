package org.test.cardshark;

import java.util.List;

/**
 * Created by wprice on 4/21/17.
 */
public interface Dealer {

  Card deal();
  List<Card> deal(int cardCount);
  int cardCount();
  void returnCards(Card...cards);
  void returnCards(List<Card> cards);
  int DECK_SIZE = 52;
}
