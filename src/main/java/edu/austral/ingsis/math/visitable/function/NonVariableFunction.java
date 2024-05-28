package edu.austral.ingsis.math.visitable.function;

import edu.austral.ingsis.math.visitable.operation.Operation;
import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;
import java.util.List;

public class NonVariableFunction implements Function {
  private final Operation operation;

  public NonVariableFunction(Parameter operation) {
    this.operation = (Operation) operation;
  }

  @Override
  public Double eval() {
    return operation.solve();
  }

  @Override
  public List<String> listVariables() {
    return List.of();
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public Operation getOperation() {
    return operation;
  }
}
