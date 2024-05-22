package edu.austral.ingsis.math.visitable.operation.unary;

import edu.austral.ingsis.math.visitable.operation.Operation;
import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;

public abstract class UnaryOperation implements Operation {
  protected Parameter parameter;

  @Override
  public abstract void accept(Visitor visitor);

  @Override
  public abstract Double solve();
}
