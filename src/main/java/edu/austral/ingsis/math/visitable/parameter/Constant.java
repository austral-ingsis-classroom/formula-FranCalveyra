package edu.austral.ingsis.math.visitable.parameter;

import edu.austral.ingsis.math.visitor.Visitor;

public class Constant implements Parameter {
  private Double value;

  public Constant(Double val) {
    value = val;
  }

  @Override
  public Double getValue() {
    return value;
  }

  @Override
  public void setValue(Double value) {
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
