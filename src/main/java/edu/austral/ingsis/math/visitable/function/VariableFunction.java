package edu.austral.ingsis.math.visitable.function;

import edu.austral.ingsis.math.visitable.operation.Operation;
import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitable.parameter.Variable;
import edu.austral.ingsis.math.visitor.Visitor;
import java.util.ArrayList;
import java.util.List;

public class VariableFunction implements Function {
  private final Operation operation;
  private final String representation;
  private final Parameter parameter;

  public VariableFunction(Operation operation) {
    this.operation = operation;
    this.representation = operation.toString();
    this.parameter = null;
  }

  public VariableFunction(Parameter parameter) {
    this.operation = null;
    this.parameter = parameter;
    this.representation = parameter.toString();
  }

  @Override
  public Double eval() {
    return operation != null ? operation.solve() : parameter.getValue().doubleValue();
  }

  @Override
  public List<String> listVariables() {
    if (operation != null) {
      return getOperationVariables(operation);
    }
    if (parameter != null) {
      if (parameter instanceof Variable) {
        return List.of(parameter.toString());
      }
    }
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
    return representation.charAt(0) == '('
        && representation.charAt(representation.length() - 1) == ')';
  }

  private List<String> getOperationVariables(Operation operation) {
    List<String> variables = new ArrayList<>();
    for (Parameter parameter : operation.getParameters()) {
      if (parameter instanceof Operation) {
        variables.addAll(getOperationVariables((Operation) parameter));
      }
      if (parameter instanceof Variable) {
        variables.add((parameter).toString());
      }
    }
    return variables;
  }
}
