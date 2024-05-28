package edu.austral.ingsis.math.visitable.parameter;

import edu.austral.ingsis.math.utils.MathNumber;
import edu.austral.ingsis.math.visitor.Visitor;

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

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public String getValueString() {
    return value.toString();
  }
}
