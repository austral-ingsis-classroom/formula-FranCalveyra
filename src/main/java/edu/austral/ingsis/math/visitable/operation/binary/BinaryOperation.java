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
  public void accept(Visitor visitor){
    visitor.visit(this);
  };

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
    return List.of(first, second);
  }

  public Parameter getFirst(){
    return first;
  }
  public Parameter getSecond(){
    return second;
  }
  public String getOperand() {
    return operand;
  }
}
