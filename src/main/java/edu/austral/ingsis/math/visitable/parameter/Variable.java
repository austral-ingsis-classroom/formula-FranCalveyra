package edu.austral.ingsis.math.visitable.parameter;

import edu.austral.ingsis.math.utils.MathNumber;
import edu.austral.ingsis.math.visitor.Visitor;

public class Variable implements Parameter {
  private final String variableName;
  private MathNumber value;

  public Variable(String variableName) {
    this.variableName = variableName;
    value = null;
  }

  @Override
  public MathNumber getValue() {
    if (value == null) {
      throw new UnsupportedOperationException("Variable has no value assigned yet");
    }
    return value;
  }

  @Override
  public void setValue(MathNumber value) {
    this.value = value;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public String toString() {
    return variableName;
  }
}
