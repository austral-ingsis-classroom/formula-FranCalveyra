package edu.austral.ingsis.math.visitable.function;

import edu.austral.ingsis.math.visitor.Visitor;

public class VariableFunction implements Function {
  private final String representation;

  public VariableFunction(String representation) {
    this.representation = representation;
  }

  @Override
  public Double eval() {
    throw new UnsupportedOperationException("Can't get a value from a variable function");
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public String getRepresentation() {
    return representation;
  }
}
