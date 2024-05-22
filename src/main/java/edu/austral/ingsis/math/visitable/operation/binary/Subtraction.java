package edu.austral.ingsis.math.visitable.operation.binary;

import edu.austral.ingsis.math.visitor.Visitor;

public class Subtraction extends BinaryOperation {
  @Override
  public void accept(Visitor visitor) {}

  @Override
  public Double solve() {
    return first.getValue().doubleValue() - second.getValue().doubleValue();
  }
}
