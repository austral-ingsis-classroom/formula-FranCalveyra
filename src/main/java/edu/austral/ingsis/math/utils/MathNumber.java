package edu.austral.ingsis.math.utils;

/** Number class wrapper */
public class MathNumber extends Number {
  private final Number value;

  public MathNumber(Number value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value.toString();
  }

  @Override
  public int intValue() {
    return value.intValue();
  }

  @Override
  public long longValue() {
    return value.longValue();
  }

  @Override
  public float floatValue() {
    return value.floatValue();
  }

  @Override
  public double doubleValue() {
    return value.doubleValue();
  }
}
