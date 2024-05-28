package edu.austral.ingsis.math.visitable.operation.unary;

import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;

public class AbsoluteValue extends UnaryOperation {
  public AbsoluteValue(Parameter parameter) {
    super(parameter);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public Double solve() {
    return Math.abs(parameter.getValue());
  }
}
