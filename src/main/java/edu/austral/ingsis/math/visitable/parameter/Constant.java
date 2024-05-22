package edu.austral.ingsis.math.visitable.parameter;

import edu.austral.ingsis.math.utils.MathNumber;

public class Constant implements Parameter {
  private MathNumber value;

  public Constant(MathNumber val) {
    value = val;
  }

  @Override
  public MathNumber getValue() {
    return value;
  }

  @Override
  public void setValue(MathNumber value) {
    this.value = value;
  }
}
