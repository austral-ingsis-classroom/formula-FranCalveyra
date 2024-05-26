package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitable.function.NonVariableFunction;
import edu.austral.ingsis.math.visitable.function.VariableFunction;
import edu.austral.ingsis.math.visitable.operation.binary.*;
import edu.austral.ingsis.math.visitable.operation.unary.AbsoluteValue;
import edu.austral.ingsis.math.visitable.operation.unary.SquareRoot;
import edu.austral.ingsis.math.visitable.parameter.Constant;
import edu.austral.ingsis.math.visitable.parameter.Variable;

public class Printer implements Visitor {
  private String lastVisitedValue;

  @Override
  public void visit(VariableFunction o) {
    lastVisitedValue = o.toString();
  }

  @Override
  public void visit(NonVariableFunction o) {
    lastVisitedValue = o.toString();
  }

  @Override
  public void visit(Constant o) {
    lastVisitedValue = o.toString();
  }

  @Override
  public void visit(Variable o) {
    lastVisitedValue = o.toString();
  }

  @Override
  public void visit(AbsoluteValue o) {
    lastVisitedValue = o.toString();
  }

  @Override
  public void visit(SquareRoot o) {

    lastVisitedValue = o.toString();
  }

  @Override
  public void visit(Addition o) {

    lastVisitedValue = o.toString();
  }

  @Override
  public void visit(Subtraction o) {
    lastVisitedValue = o.toString();
  }

  @Override
  public void visit(Product o) {
    lastVisitedValue = o.toString();
  }

  @Override
  public void visit(Power o) {
    lastVisitedValue = o.toString();
  }

  @Override
  public void visit(Division o) {
    lastVisitedValue = o.toString();
  }

  public String getLastVisitedValue() {
    return lastVisitedValue;
  }
}
