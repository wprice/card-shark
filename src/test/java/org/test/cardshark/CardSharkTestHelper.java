package org.test.cardshark;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Assert;

/**
 * Created by wprice on 4/21/17.
 */
public class CardSharkTestHelper {

  public static <T> void typeComplies(T t) {
    Assert.assertNotNull(t);
    Assert.assertEquals(t, t);
    Assert.assertNotNull(t.toString());
    Assert.assertNotEquals(t, null);
    Assert.assertNotEquals(t, createAndPopulate(t.getClass()));
    Assert.assertNotEquals(t.hashCode(), createAndPopulate(t.getClass()).hashCode());
  }

  private static <T> T createAndPopulate(Class<T> c) {
    return random(c);
  }

  public static <T> T random(Class<T> t) {

    try {
      return t.getConstructor(Suit.class, int.class).newInstance(randomSuit(), randomCardValue());
    }catch (Exception e) {
      throw new IllegalStateException(e.getCause());
    }

  }

  public static List<Card> randomCards(int count) {
    return new Deck(true).getCards(count);
  }

  public static Suit randomSuit() {
    return Suit.valueOf(new Random().nextInt(Suit.values().length));
  }

  public static Card randomCard() {
    return new Card(randomSuit(), randomCardValue());
  }

  public static Card randomCard(boolean faceCard) {
    return (faceCard) ? new Card(randomSuit(), randomCardValue(FaceCardType.JACK.getValue(), FaceCardType.ACE.getValue())) : randomCard();
  }

  public static int randomCardValue(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max);
  }
  private static int randomCardValue() {
    return randomCardValue(CardSharkHelper.MIN_CARD, CardSharkHelper.MAX_CARD);
  }

  public static List<Card> cardsOfSameSuit(int count, final Suit suit) {
    return IntStream.rangeClosed(0, count).mapToObj(value -> new Card(suit, randomCardValue())).collect(
        Collectors.toList());
  }
}
