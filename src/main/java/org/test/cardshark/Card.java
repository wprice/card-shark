package org.test.cardshark;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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

  public int getValue() {
    return value;
  }

  public boolean isFaceCard() {
    return faceCard;
  }

  @Override
  public String toString() {

    String strValue = (isFaceCard()) ? FaceCardType.valueOf(getValue()).toString() : String.valueOf(getValue());
    return "[" + strValue + " of " + getSuit() + "S]";
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
