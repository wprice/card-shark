package org.test.cardshark.impl;

import org.test.cardshark.Dealer;
import org.test.cardshark.Deck;

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



}
