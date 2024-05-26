package edu.austral.ingsis.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.austral.ingsis.math.utils.MathNumber;
import org.junit.jupiter.api.Test;

public class MathNumberTest {

  private final MathNumber mathNumber = new MathNumber(20);

  @Test
  public void intValueTest() {
    assertEquals(20, mathNumber.intValue());
  }

  @Test
  public void longValueTest() {
    assertEquals(20L, mathNumber.longValue());
  }

  @Test
  public void doubleValueTest() {
    assertEquals(20d, mathNumber.doubleValue());
  }

  @Test
  public void floatValueTest() {
    assertEquals(20F, mathNumber.floatValue());
  }
}
