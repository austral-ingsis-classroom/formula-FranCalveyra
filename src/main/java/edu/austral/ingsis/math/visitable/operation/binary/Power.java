package edu.austral.ingsis.math.visitable.operation.binary;

import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;

public class Power extends BinaryOperation {
  public Power(Parameter first, Parameter second) {
    super(first, second);
    super.operand = "^";
  }

  @Override
  public Double solve() {
    return Math.pow(first.getValue().doubleValue(), second.getValue().doubleValue());
  }
}
