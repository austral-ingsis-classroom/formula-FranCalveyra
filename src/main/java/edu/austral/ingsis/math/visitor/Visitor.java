package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitable.function.NonVariableFunction;
import edu.austral.ingsis.math.visitable.function.VariableFunction;
import edu.austral.ingsis.math.visitable.operation.binary.Addition;
import edu.austral.ingsis.math.visitable.operation.binary.Product;
import edu.austral.ingsis.math.visitable.operation.binary.Subtraction;
import edu.austral.ingsis.math.visitable.operation.unary.AbsoluteValue;
import edu.austral.ingsis.math.visitable.operation.unary.SquareRoot;
import edu.austral.ingsis.math.visitable.parameter.Constant;

public interface Visitor {
  void visit(VariableFunction o);

  void visit(NonVariableFunction o);

  void visit(Constant o);

  void visit(AbsoluteValue o);

  void visit(SquareRoot o);

  void visit(Addition o);

  void visit(Subtraction o);

  void visit(Product o);
  // TODO: use the rest of actual CLASSES, not interface delegations
}
