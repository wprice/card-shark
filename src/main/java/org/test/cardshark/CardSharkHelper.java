package org.test.cardshark;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wprice on 5/7/17.
 */
public class CardSharkHelper {

  private static final Logger logger = LoggerFactory.getLogger(CardSharkHelper.class);

  public static void dumpCards(final List<Card> cards) {
    cards.forEach(System.out::println);
  }

}
