package edu.austral.ingsis.math.visitable.operation.binary;

import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitor.Visitor;

public class Product extends BinaryOperation {
  public Product(Parameter first, Parameter second) {
    super(first, second);
    super.operand = "*";
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public Double solve() {
    return first.getValue().doubleValue() * second.getValue().doubleValue();
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
