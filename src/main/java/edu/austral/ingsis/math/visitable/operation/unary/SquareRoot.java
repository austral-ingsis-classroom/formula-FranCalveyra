package edu.austral.ingsis.math.visitable.operation.unary;

import edu.austral.ingsis.math.visitor.Visitor;

public class SquareRoot extends UnaryOperation {
  @Override
  public void accept(Visitor visitor) {}

  @Override
  public Double solve() {
    return Math.pow(parameter.getValue().doubleValue(), 0.5);
  }
}
