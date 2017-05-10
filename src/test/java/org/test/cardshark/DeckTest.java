package org.test.cardshark;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Created by wprice on 4/21/17.
 */
public class DeckTest {

  @Test
  public void testDeck() {
    Deck deck = new Deck();
    assertThat(deck, notNullValue());
    assertThat(deck.size(), is(Dealer.DECK_SIZE));
    assertThat(deck, equalTo(new Deck()));

    deck.shuffle();

    //TODO, for lists etc, order is significant...what to do here?
    assertThat(deck, not(new Deck()));

  }


  @Test
  public void testShuffle() {
    Deck deck = new Deck();
    assertThat(deck, notNullValue());
    assertThat(deck.size(), is(52));
    assertThat(deck, equalTo(new Deck()));

    deck.shuffle();

    //TODO, for lists etc, order is significant...what to do here?
    assertThat(deck, not(new Deck()));
    assertThat(deck.size(), is(52));

    assertThat(new Deck(true), not(new Deck()));
  }

  @Test
  public void testDeal() {
    Deck deck = new Deck(true);
    assertThat(deck, notNullValue());
    assertThat(deck.getCards(3).size(), is(3));
    assertThat(deck.size(), is(52 - 3));

  }

}
