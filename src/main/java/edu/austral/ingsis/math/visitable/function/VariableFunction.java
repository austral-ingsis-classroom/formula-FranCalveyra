package edu.austral.ingsis.math.visitable.function;

import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;
import java.util.Map;

public class VariableFunction implements Function {
  private Map<Parameter, Number> parameters;

  public VariableFunction(Map<Parameter, Number> parameters) {
    this.parameters = parameters;
  }

  @Override
  public Number eval() {
    throw new UnsupportedOperationException("Can't get a value from a variable function");
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
