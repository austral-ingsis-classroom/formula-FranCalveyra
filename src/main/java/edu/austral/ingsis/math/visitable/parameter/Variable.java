package edu.austral.ingsis.math.visitable.parameter;

import edu.austral.ingsis.math.utils.MathNumber;

public class Variable implements Parameter {
  private final String variableName;
  private MathNumber value;

  public Variable(String variableName) {
    this.variableName = variableName;
  }

  public String getVariableName() {
    return variableName;
  }

  @Override
  public MathNumber getValue() {
    if (value == null) {
      throw new UnsupportedOperationException("Variable has no numeric value");
    }
    return value;
  }

  @Override
  public void setValue(MathNumber value) {
    this.value = value;
  }
}
