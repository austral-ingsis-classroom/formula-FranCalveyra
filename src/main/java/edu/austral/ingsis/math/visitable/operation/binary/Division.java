package edu.austral.ingsis.math.visitable.operation.binary;

import edu.austral.ingsis.math.visitable.parameter.Parameter;

public class Division extends BinaryOperation {
  public Division(Parameter first, Parameter second) {
    super(first, second);
    super.operand = "/";
  }

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
