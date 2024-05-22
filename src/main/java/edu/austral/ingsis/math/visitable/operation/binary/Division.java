package edu.austral.ingsis.math.visitable.operation.binary;

import edu.austral.ingsis.math.visitor.Visitor;

public class Division extends BinaryOperation {
  @Override
  public void accept(Visitor visitor) {}

  @Override
  public Double solve() {
    try {
      return first.getValue().doubleValue() / second.getValue().doubleValue();
    } catch (ArithmeticException e) {
      System.out.println("Cannot divide by zero");
      return 0.0;
    }
  }
}
