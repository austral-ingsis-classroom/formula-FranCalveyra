package edu.austral.ingsis.math.visitable.operation.unary;

import edu.austral.ingsis.math.visitor.Visitor;

public class AbsoluteValue extends UnaryOperation {
  @Override
  public void accept(Visitor visitor) {}

  @Override
  public Double solve() {
    return Math.abs(parameter.getValue().doubleValue());
  }
}
