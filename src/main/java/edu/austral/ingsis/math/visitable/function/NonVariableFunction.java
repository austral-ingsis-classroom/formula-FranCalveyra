package edu.austral.ingsis.math.visitable.function;

import edu.austral.ingsis.math.visitor.Visitor;

public class NonVariableFunction implements Function {
  private final Number constantValue;

  public NonVariableFunction(Number value) {
    this.constantValue = value;
  }

  @Override
  public Number eval() {
    return constantValue;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
