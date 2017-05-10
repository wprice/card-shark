package org.test.cardshark;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by wprice on 4/21/17.
 */
public class Card {


  private Suit suit;
  private int value;


  public Card(final Suit suit, final int value) {

    if(value < CardSharkHelper.MIN_CARD || value > CardSharkHelper.MAX_CARD) {
      throw new IllegalStateException("Invalid card value: " + value);
    }

    this.suit = suit;
    this.value = value;
  }

  public static org.test.cardshark.Card cardWithValues(final Suit suit, final int value) {
    return new Card(suit, value);
  }

  public Suit getSuit() {
    return suit;
  }

  public int getValue() {
    return value;
  }

  public boolean isFaceCard() {
   return FaceCardType.isFaceCard(getValue());
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
