package org.test.cardshark.impl;

import java.util.ArrayList;
import java.util.List;
import org.test.cardshark.Card;
import org.test.cardshark.Dealer;
import org.test.cardshark.Deck;
import org.test.cardshark.Suit;

/**
 * Created by wprice on 4/21/17.
 */
public class DealerImpl implements Dealer {

  private static final int DEFAULT_DECKS = 1;
  private static final int DEFAULT_DECK_SIZE = 52;

  public Deck shuffle(Deck deck) {
    return null;
  }

  public Deck shuffle() {
    return shuffle(DEFAULT_DECKS);
  }

  public Deck shuffle(int decks) {
    return null;
  }

  public List<Card> orderedDeck() {

    List<Card> cards = new ArrayList<Card>();

    for (Suit suit : Suit.values()) {
      for (int i = 1; i < 13; i++) {
        cards.add(new Card(suit, i));
      }
    }

    return cards;
  }

  @Override
  public Card deal() {
    return null;
  }

  @Override
  public List<Card> deal(int cardCount) {
    return null;
  }
}
