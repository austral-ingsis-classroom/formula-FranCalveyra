package edu.austral.ingsis.math.visitable.operation.binary;

import edu.austral.ingsis.math.visitable.operation.Operation;
import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;

public abstract class BinaryOperation implements Operation {
  protected Parameter first;
  protected Parameter second;

  @Override
  public abstract void accept(Visitor visitor);

  @Override
  public abstract Double solve();
}
