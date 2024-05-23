package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitable.function.NonVariableFunction;
import edu.austral.ingsis.math.visitable.function.VariableFunction;
import edu.austral.ingsis.math.visitable.operation.binary.*;
import edu.austral.ingsis.math.visitable.operation.unary.AbsoluteValue;
import edu.austral.ingsis.math.visitable.operation.unary.SquareRoot;
import edu.austral.ingsis.math.visitable.parameter.Constant;
import edu.austral.ingsis.math.visitable.parameter.Variable;

public class Printer implements Visitor {
  @Override
  public void visit(VariableFunction o) {
    System.out.println(o.getRepresentation());
  }

  @Override
  public void visit(NonVariableFunction o) {
    System.out.println(o.eval());
  }

  @Override
  public void visit(Constant o) {
    System.out.println(o.getValue());
  }

  @Override
  public void visit(Variable o) {
    System.out.println(o.getVariableName());
  }
  //TODO: implement operation visits
  @Override
  public void visit(AbsoluteValue o) {
    System.out.println();
  }

  @Override
  public void visit(SquareRoot o) {
    System.out.println();
  }

  @Override
  public void visit(Addition o) {
    System.out.println();
  }

  @Override
  public void visit(Subtraction o) {}

  @Override
  public void visit(Product o) {}

  @Override
  public void visit(Power o) {}

  @Override
  public void visit(Division o) {}
}
