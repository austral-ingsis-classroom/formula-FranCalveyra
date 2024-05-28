package edu.austral.ingsis.math.visitable.operation.binary;

import edu.austral.ingsis.math.visitable.parameter.Parameter;

public class Addition extends BinaryOperation {
  public Addition(Parameter first, Parameter second) {
    super(first, second);
    super.operand = "+";
  }

  @Override
  public Double solve() {
    return first.getValue().doubleValue() + second.getValue().doubleValue();
  }

}
