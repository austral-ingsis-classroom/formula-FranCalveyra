package edu.austral.ingsis.math.visitable.operation.unary;

import edu.austral.ingsis.math.utils.MathNumber;
import edu.austral.ingsis.math.visitable.operation.Operation;
import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;
import java.util.List;

public abstract class UnaryOperation implements Operation {
  protected Parameter parameter;

  public UnaryOperation(Parameter parameter) {
    this.parameter = parameter;
  }

  @Override
  public abstract void accept(Visitor visitor);

  @Override
  public abstract Double solve();

  @Override
  public MathNumber getValue() {
    return new MathNumber(solve());
  }

  @Override
  public void setValue(MathNumber value) {
    return;
  }

  @Override
  public List<Parameter> getParameters() {
    return List.of(parameter);
  }
}
