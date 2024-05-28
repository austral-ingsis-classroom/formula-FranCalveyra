package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitable.function.NonVariableFunction;
import edu.austral.ingsis.math.visitable.function.VariableFunction;
import edu.austral.ingsis.math.visitable.operation.binary.*;
import edu.austral.ingsis.math.visitable.operation.unary.AbsoluteValue;
import edu.austral.ingsis.math.visitable.operation.unary.SquareRoot;
import edu.austral.ingsis.math.visitable.parameter.Constant;
import edu.austral.ingsis.math.visitable.parameter.Parameter;
import edu.austral.ingsis.math.visitable.parameter.Variable;

public class Printer implements Visitor {
  private String lastVisitedValue;

  @Override
  public void visit(VariableFunction o) {
    o.getOperation().accept(this);
    String representation = lastVisitedValue;
    boolean cond = isBetweenParenthesis(representation);
    lastVisitedValue =
        cond ? representation.substring(1, representation.length() - 1) : representation;
  }

  private boolean isBetweenParenthesis(String representation) {
    return representation.charAt(0) == '('
        && representation.charAt(representation.length() - 1) == ')';
  }

  @Override
  public void visit(NonVariableFunction o) {
    o.getOperation().accept(this);
    String representation = lastVisitedValue;
    boolean cond = isBetweenParenthesis(representation);
    lastVisitedValue =
        cond ? representation.substring(1, representation.length() - 1) : representation;
  }

  @Override
  public void visit(Constant o) {
    lastVisitedValue = o.getValueString();
  }

  @Override
  public void visit(Variable o) {
    lastVisitedValue = o.getVariable();
  }

  @Override
  public void visit(BinaryOperation binaryOperation) {
    Parameter first = binaryOperation.getFirst();
    Parameter second = binaryOperation.getSecond();
    String operand = binaryOperation.getOperand();
    Printer printer = new Printer();
    first.accept(printer);
    Printer secondPrinter = new Printer();
    second.accept(secondPrinter);

    lastVisitedValue =
        "(" + printer.lastVisitedValue + " " + operand + " " + secondPrinter.lastVisitedValue + ")";
  }

  @Override
  public void visit(AbsoluteValue o) {
    Printer auxPrinter = new Printer();
    o.getParameter().accept(auxPrinter);
    lastVisitedValue = "|" + auxPrinter.lastVisitedValue + "|";
  }

  @Override
  public void visit(SquareRoot o) {
    Printer auxPrinter = new Printer();
    o.getParameter().accept(auxPrinter);
    lastVisitedValue = auxPrinter.lastVisitedValue + " ^ (1/2)";
  }

  public String getLastVisitedValue() {
    return lastVisitedValue;
  }
}
