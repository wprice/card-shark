package org.test.cardshark;

import java.util.List;

/**
 * Created by wprice on 4/21/17.
 */
public interface Dealer {

  Deck shuffle(Deck deck);

  Deck shuffle();

  Deck shuffle(int decks);

  Card deal();

  List<Card> deal(int cardCount);
}
