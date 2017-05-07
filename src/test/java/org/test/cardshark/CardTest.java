package org.test.cardshark;

import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Created by wprice on 4/21/17.
 */
public class CardTest {


  @Test
  public void testCard() {
    PodamFactoryImpl factory = new PodamFactoryImpl();
    Card random = factory.manufacturePojoWithFullData(Card.class);
    CardSharkTestHelper.typeComplies(random);
  }
}
