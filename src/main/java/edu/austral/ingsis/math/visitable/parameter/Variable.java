package edu.austral.ingsis.math.visitable.parameter;

import edu.austral.ingsis.math.visitor.Visitor;

public class Variable implements Parameter {
  private final String variableName;
  private Double value;

  public Variable(String variableName) {
    this.variableName = variableName;
    value = null;
  }

  @Override
  public Double getValue() {
    if (value == null) {
      throw new UnsupportedOperationException("Variable has no value assigned yet");
    }
    return value;
  }

  @Override
  public void setValue(Double value) {
    this.value = value;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public String getVariable() {
    return value == null ? variableName : value.toString();
  }
}
