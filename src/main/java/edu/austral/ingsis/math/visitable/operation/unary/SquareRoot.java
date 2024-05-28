package edu.austral.ingsis.math.visitable.operation.unary;

import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;

public class SquareRoot extends UnaryOperation {
  public SquareRoot(Parameter parameter) {
    super(parameter);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public Double solve() {
    try {
      return Math.pow(parameter.getValue(), 0.5);
    } catch (ArithmeticException e) {
      System.out.println("Cannot get sqrt of a negative number");
      return 0.0;
    }
  }
}
