package edu.austral.ingsis.math.visitable.function;

import edu.austral.ingsis.math.visitable.operation.Operation;
import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitable.parameter.Variable;
import edu.austral.ingsis.math.visitor.Printer;
import edu.austral.ingsis.math.visitor.Visitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VariableFunction implements Function {
  private final Operation operation;
  private final Parameter parameter;

  public VariableFunction(Operation operation) {
    this.operation = operation;
    this.parameter = null;
  }

  public VariableFunction(Parameter parameter) {
    this.operation = null;
    this.parameter = parameter;
  }

  @Override
  public Double eval() {
    return operation != null ? operation.solve() : Objects.requireNonNull(parameter).getValue().doubleValue();
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

  public Operation getOperation() {
    return operation;
  }

  private List<String> getOperationVariables(Operation operation) {
    List<String> variables = new ArrayList<>();
    Printer printer = new Printer();
    for (Parameter parameter : operation.getParameters()) {
      if (parameter instanceof Operation) {
        variables.addAll(getOperationVariables((Operation) parameter));
      }
      if (parameter instanceof Variable) {
        printer.visit((Variable) parameter);
        variables.add(printer.getLastVisitedValue());
      }
    }
    return variables;
  }
}
