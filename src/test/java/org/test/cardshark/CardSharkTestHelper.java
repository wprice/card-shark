package org.test.cardshark;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Assert;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Created by wprice on 4/21/17.
 */
public class CardSharkTestHelper {

  public static <T> void typeComplies(Class<T> c) {

    try {
      typeComplies(c.newInstance());

    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

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
    PodamFactoryImpl factory = new PodamFactoryImpl();
    return factory.manufacturePojoWithFullData(t);
  }

  public static <T> List<T> randomList(Class<T> t, int count) {
    List<T> l = new ArrayList<>();
    for(int i = 0; i < count; i++) {
      l.add(random(t));
    }

    return l;
  }

  public static List<Card> randomCards(int count) {
    return new Deck(true).getCards(count);
    //return IntStream.range(0, count).mapToObj(value -> randomCard(false)).collect(Collectors.toList());
  }

  public static Suit randomSuit() {
    return Suit.valueOf(new Random().nextInt(Suit.values().length));
  }

  public static Card randomCard() {
    return randomCard(false);
  }
  public static Card randomCard(boolean faceCard) {
    return new Card(randomSuit(), randomCardValue(faceCard));
  }

  private static int randomCardValue(boolean faceCard) {
    return (faceCard) ? ThreadLocalRandom.current().nextInt(11, 14)
        : ThreadLocalRandom.current().nextInt(CardSharkHelper.MIN_CARD, CardSharkHelper.MAX_CARD);
  }

}
