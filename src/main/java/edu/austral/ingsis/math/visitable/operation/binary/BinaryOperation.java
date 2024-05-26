package edu.austral.ingsis.math.visitable.operation.binary;

import edu.austral.ingsis.math.utils.MathNumber;
import edu.austral.ingsis.math.visitable.operation.Operation;
import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;

import java.util.List;

public abstract class BinaryOperation implements Operation {
  protected Parameter first;
  protected Parameter second;
  protected String operand;

  public BinaryOperation(Parameter first, Parameter second) {
    this.first = first;
    this.second = second;
  }

  @Override
  public abstract void accept(Visitor visitor);

  @Override
  public abstract Double solve();

  @Override
  public String toString() {
    return "(" + first.toString() + " " + operand + " " + second.toString() + ")";
  }

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
    return List.of(first, second);
  }

}
