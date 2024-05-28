package edu.austral.ingsis.math.visitable.operation.binary;

import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;

public class Subtraction extends BinaryOperation {
  public Subtraction(Parameter first, Parameter second) {
    super(first, second);
    super.operand = "-";
  }

  @Override
  public Double solve() {
    return first.getValue().doubleValue() - second.getValue().doubleValue();
  }

}
