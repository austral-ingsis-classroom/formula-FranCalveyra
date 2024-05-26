package edu.austral.ingsis.math.visitable.function;

import edu.austral.ingsis.math.visitable.operation.Operation;
import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;

import java.util.List;

public class NonVariableFunction implements Function {
  private final Operation operation;
  private final String representation;
  private final Parameter parameter;

  public NonVariableFunction(Operation operation) {
    this.operation = operation;
    this.representation = operation.toString();
    this.parameter = null;
  }

  public NonVariableFunction(Parameter parameter) {
    this.operation = null;
    this.parameter = parameter;
    this.representation = parameter.toString();
  }

  @Override
  public Double eval() {
    return operation != null ? operation.solve() : Double.valueOf(parameter.getValue().doubleValue());
  }

  @Override
  public List<String> listVariables() {
    return List.of();
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public String toString() {
    boolean cond = isBetweenParenthesis(representation);
    return cond ? representation.substring(1, representation.length() - 1) : representation;
  }
  private boolean isBetweenParenthesis(String representation) {
    return representation.charAt(0) == '(' && representation.charAt(representation.length() - 1) == ')';
  }
}
