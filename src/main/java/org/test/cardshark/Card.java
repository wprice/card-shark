package org.test.cardshark;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by wprice on 4/21/17.
 */
public class Card {

  private static final List<Integer> faceCards = new ArrayList<>();

  static {
    faceCards.add(1);
    faceCards.add(11);
    faceCards.add(12);
    faceCards.add(13);
  }
  private Suit suit;
  private int value;
  private boolean faceCard;

  public Card(Suit suit, Integer value) {
    this.suit = suit;
    this.value = value;
    this.faceCard = faceCards.contains(value);
  }

  public static org.test.cardshark.Card cardWithValues(final Suit suit, final Integer value) {
    return new Card(suit, value);
  }

  public Suit getSuit() {
    return suit;
  }

  public void setSuit(Suit suit) {
    this.suit = suit;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }


  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
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
