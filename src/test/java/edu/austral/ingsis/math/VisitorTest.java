package edu.austral.ingsis.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.austral.ingsis.math.utils.MathNumber;
import edu.austral.ingsis.math.visitable.function.NonVariableFunction;
import edu.austral.ingsis.math.visitable.function.VariableFunction;
import edu.austral.ingsis.math.visitable.operation.binary.*;
import edu.austral.ingsis.math.visitable.operation.unary.SquareRoot;
import edu.austral.ingsis.math.visitable.parameter.Constant;
import edu.austral.ingsis.math.visitable.parameter.Variable;
import edu.austral.ingsis.math.visitor.Printer;
import org.junit.jupiter.api.Test;

public class VisitorTest {

  @Test
  public void additionVisitTest() {
    final Printer printer = new Printer();
    final Addition addition =
        new Addition(new Constant(new MathNumber(1)), new Constant(new MathNumber(1)));
    printer.visit(addition);
    assertEquals("(1 + 1)", printer.getLastVisitedValue());
  }

  @Test
  public void subtractionVisitTest() {
    final Printer printer = new Printer();
    final Subtraction addition =
        new Subtraction(new Constant(new MathNumber(1)), new Constant(new MathNumber(1)));
    printer.visit(addition);
    assertEquals("(1 - 1)", printer.getLastVisitedValue());
  }

  @Test
  public void divisionVisitTest() {
    final Printer printer = new Printer();
    final Division addition =
        new Division(new Constant(new MathNumber(1)), new Constant(new MathNumber(1)));
    printer.visit(addition);
    assertEquals("(1 / 1)", printer.getLastVisitedValue());
  }

  @Test
  public void productVisitTest() {
    final Printer printer = new Printer();
    final Product addition =
        new Product(new Constant(new MathNumber(1)), new Constant(new MathNumber(1)));
    printer.visit(addition);
    assertEquals("(1 * 1)", printer.getLastVisitedValue());
  }

  @Test
  public void powerVisitTest() {
    final Printer printer = new Printer();
    final Power addition =
        new Power(new Constant(new MathNumber(1)), new Constant(new MathNumber(1)));
    printer.visit(addition);
    assertEquals("(1 ^ 1)", printer.getLastVisitedValue());
  }

  @Test
  public void squareRootVisitTest() {
    final Printer printer = new Printer();
    final SquareRoot addition = new SquareRoot(new Constant(new MathNumber(1)));
    printer.visit(addition);
    assertEquals("1 ^ (1/2)", printer.getLastVisitedValue());
  }

  @Test
  public void constantVisitTest() {
    final Printer printer = new Printer();
    final Constant c = new Constant(new MathNumber(1));
    printer.visit(c);
    assertEquals("1", printer.getLastVisitedValue());
  }

  @Test
  public void variableVisitTest() {
    final Printer printer = new Printer();
    final Variable x = new Variable("x");
    printer.visit(x);
    assertEquals("x", printer.getLastVisitedValue());
  }

  @Test
  public void variableFunctionVisitTest() {
    final Printer printer = new Printer();
    final Variable x = new Variable("x");
    final VariableFunction function =
        new VariableFunction(new Addition(x, new Constant(new MathNumber(1))));
    printer.visit(function);
    assertEquals("x + 1", printer.getLastVisitedValue());
  }

  @Test
  public void nonVariableFunctionVisitTest() {
    final Printer printer = new Printer();
    final NonVariableFunction function =
        new NonVariableFunction(
            new Addition(new Constant(new MathNumber(3)), new Constant(new MathNumber(1))));
    printer.visit(function);
    assertEquals("3 + 1", printer.getLastVisitedValue());
  }
}
