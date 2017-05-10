package org.test.cardshark;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wprice on 4/21/17.
 */
public class DealerTest {

  @Test
  public void testDealerFactory() {
    Dealer dealer = DealerFactory.createDealer();
    Assert.assertNotNull(dealer);
    Assert.assertNotEquals(dealer, DealerFactory.createDealer());
  }

  @Test
  public void testMultipleDecks() {
    Dealer dealer = DealerFactory.createDealer(3);
    assertThat(dealer.cardCount(), equalTo(Dealer.DECK_SIZE * 3));
  }

  @Test
  public void testDealCard() {
    Dealer dealer = DealerFactory.createDealer();
    Card card = dealer.deal();
    assertThat(card, notNullValue());
    assertThat(card, not(dealer.deal()));
    assertThat(dealer.cardCount(), equalTo(52 - 2));
  }

  @Test
  public void testDealCards() {
    Dealer dealer = DealerFactory.createDealer();
    List<Card> cards = dealer.deal(5);
    CardSharkHelper.dumpCards(cards);
    assertThat(cards, notNullValue());
    assertThat(cards.isEmpty(), is(false));
    assertThat(cards.size(), is(5));

  }

  @Test
  public void testReturnCards() {
    Dealer dealer = DealerFactory.createDealer();
    List<Card> cards = dealer.deal(5);
    assertThat(dealer.cardCount(), is(Dealer.DECK_SIZE - 5));
    dealer.returnCards(cards);

  }

}
