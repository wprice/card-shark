package org.test.cardshark.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.test.cardshark.Card;
import org.test.cardshark.Dealer;
import org.test.cardshark.Deck;
import org.test.cardshark.Suit;

/**
 * Created by wprice on 4/21/17.
 */
public class DealerImpl implements Dealer {

  private Stack<Card> decks = new Stack<>();

  private static final int DEFAULT_DECKS = 1;

  public DealerImpl() {
    this(DEFAULT_DECKS, false);
  }

  public DealerImpl(int deckCount, boolean shuffle) {

    IntStream.range(0, deckCount).forEach(value -> {
      Arrays.stream(Suit.values()).forEach(suit -> {
        IntStream.range(1, 14).forEach(operand -> decks.push(new Card(suit, operand)));
      });
    });

    shuffle();
  }


  @Override
  public Card deal() {
    return decks.pop();
  }

  @Override
  public List<Card> deal(int count) {
    return IntStream.range(0, count).mapToObj(value -> decks.pop()).collect(Collectors.toList());
  }

  @Override
  public int cardCount() {
    return decks.size();
  }

  private void shuffle() {
    Collections.shuffle(decks);
  }

  @Override
  public void returnCards(Card... cards) {
    Arrays.stream(cards).filter(card -> !decks.contains(card)).map(card -> decks.add(card));
    shuffle();
  }

  @Override
  public void returnCards(List<Card> cards) {
    returnCards(cards.toArray(new Card[cards.size()]));
  }
}
