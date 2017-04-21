package org.test.cardshark.impl;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.test.cardshark.Card;
import org.test.cardshark.Suit;

/**
 * Created by wprice on 4/21/17.
 */
public class CardImpl implements Card {

    private Suit suit;
    private Integer value;

    CardImpl(Suit suit, Integer value) {
    }

    public Suit getSuit() {
        return suit;
    }

    public Integer getValue() {
        return value;
    }

    public static Card cardWithValues(Suit suit, Integer value) {
        return new CardImpl(suit, value);
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
