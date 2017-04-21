package org.test.cardshark;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Created by wprice on 4/21/17.
 */
public class Deck{

    private final Deque<Card> deck = new ArrayDeque<Card>();

    public Card dealCard() {
        return deck.getFirst();
    }

    public Deck fromList(List<Card> cards) {
        deck.addAll(cards);
        return this;
    }

}
