package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitable.function.NonVariableFunction;
import edu.austral.ingsis.math.visitable.function.VariableFunction;
import edu.austral.ingsis.math.visitable.operation.binary.*;
import edu.austral.ingsis.math.visitable.operation.unary.AbsoluteValue;
import edu.austral.ingsis.math.visitable.operation.unary.SquareRoot;
import edu.austral.ingsis.math.visitable.parameter.Constant;
import edu.austral.ingsis.math.visitable.parameter.Variable;

public interface Visitor {

  // Function visits
  void visit(VariableFunction o);

  void visit(NonVariableFunction o);

  // Parameters visits
  void visit(Constant o);

  void visit(Variable o);

  // Operation visits
  void visit(BinaryOperation binaryOperation);

  void visit(AbsoluteValue absoluteValue);

  void visit(SquareRoot squareRoot);
}
