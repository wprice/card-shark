package org.test.cardshark;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by wprice on 4/21/17.
 */
public class Deck {

  private final Stack<Card> deck = new Stack<>();

  public Deck(boolean shuffle) {
    Arrays.stream(Suit.values()).forEach(suit -> {
      IntStream.range(1, 14).forEach(operand -> deck.push(new Card(suit, operand)));
    });

    if(shuffle) {
      shuffle();
    }
  }
  public Deck() {
   this(false);
  }

  public List<Card> dealCards(int count) {
    return IntStream.range(0, count).mapToObj(value -> deck.pop()).collect(Collectors.toList());
  }
  public Card dealCard() {
    return dealCards(1).get(0);
  }

  public Deck fromList(List<Card> cards) {
    deck.addAll(cards);
    return this;
  }

  public int size() {
    return deck.size();
  }

  public void shuffle() {
    Collections.shuffle(deck);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }
}
