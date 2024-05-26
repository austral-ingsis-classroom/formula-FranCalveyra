package edu.austral.ingsis.math.visitable.operation.binary;

import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;

public class Division extends BinaryOperation {
  public Division(Parameter first, Parameter second) {
    super(first, second);
    super.operand = "/";
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
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

  @Override
  public String toString() {
    return super.toString();
  }
}
