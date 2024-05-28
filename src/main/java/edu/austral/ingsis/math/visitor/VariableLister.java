package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitable.function.NonVariableFunction;
import edu.austral.ingsis.math.visitable.function.VariableFunction;
import edu.austral.ingsis.math.visitable.operation.binary.BinaryOperation;
import edu.austral.ingsis.math.visitable.operation.unary.AbsoluteValue;
import edu.austral.ingsis.math.visitable.operation.unary.SquareRoot;
import edu.austral.ingsis.math.visitable.parameter.Constant;
import edu.austral.ingsis.math.visitable.parameter.Variable;
import java.util.List;

public class VariableLister implements Visitor {
  List<String> list;

  @Override
  public void visit(VariableFunction o) {
    list = o.listVariables();
  }

  @Override
  public void visit(NonVariableFunction o) {
    list = o.listVariables();
  }

  @Override
  public void visit(Constant o) {
    list = List.of();
  }

  @Override
  public void visit(Variable o) {
    Printer printer = new Printer();
    printer.visit(o);
    list = List.of(printer.getLastVisitedValue());
  }

  @Override
  public void visit(BinaryOperation binaryOperation) {
    VariableFunction function = new VariableFunction(binaryOperation);
    visit(function);
  }

  @Override
  public void visit(AbsoluteValue absoluteValue) {
    VariableFunction function = new VariableFunction(absoluteValue);
    visit(function);
  }

  @Override
  public void visit(SquareRoot squareRoot) {
    VariableFunction function = new VariableFunction(squareRoot);
    visit(function);
  }

  public List<String> getVariableList() {
    return list;
  }
}
