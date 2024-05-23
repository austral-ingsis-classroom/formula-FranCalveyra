package edu.austral.ingsis.math.visitable.function;

import edu.austral.ingsis.math.visitor.Visitor;

public class NonVariableFunction implements Function {
  private final Double constantValue;

  public NonVariableFunction(Double value) {
    this.constantValue = value;
  }

  @Override
  public Double eval() {
    return constantValue;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
