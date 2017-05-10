package org.test.cardshark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by wprice on 4/21/17.
 */
public class Card {


  private Suit suit;
  private int value;


  public Card(Suit suit, Integer value) {
    this.suit = suit;
    this.value = value;
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
