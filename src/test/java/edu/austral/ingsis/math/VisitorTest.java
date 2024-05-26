package edu.austral.ingsis.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.austral.ingsis.math.utils.MathNumber;
import edu.austral.ingsis.math.visitable.function.NonVariableFunction;
import edu.austral.ingsis.math.visitable.function.VariableFunction;
import edu.austral.ingsis.math.visitable.operation.binary.*;
import edu.austral.ingsis.math.visitable.operation.unary.AbsoluteValue;
import edu.austral.ingsis.math.visitable.operation.unary.SquareRoot;
import edu.austral.ingsis.math.visitable.parameter.Constant;
import edu.austral.ingsis.math.visitable.parameter.Variable;
import edu.austral.ingsis.math.visitor.Printer;
import org.junit.jupiter.api.Test;

public class VisitorTest {

  @Test
  public void additionVisitTest() {
    final String expected = "(1 + 1)";
    final Printer printer = new Printer();
    final Addition addition =
        new Addition(new Constant(new MathNumber(1)), new Constant(new MathNumber(1)));
    printer.visit(addition);
    assertEquals(expected, printer.getLastVisitedValue());
    Printer otherPrinter = new Printer();
    addition.accept(otherPrinter);
    assertEquals(expected, otherPrinter.getLastVisitedValue());
  }

  @Test
  public void subtractionVisitTest() {
    final String expected = "(1 - 1)";
    final Printer printer = new Printer();
    final Subtraction subtraction =
        new Subtraction(new Constant(new MathNumber(1)), new Constant(new MathNumber(1)));
    printer.visit(subtraction);
    assertEquals(expected, printer.getLastVisitedValue());
    Printer otherPrinter = new Printer();
    subtraction.accept(otherPrinter);
    assertEquals(expected, otherPrinter.getLastVisitedValue());
  }

  @Test
  public void divisionVisitTest() {
    final String expected = "(1 / 1)";
    final Printer printer = new Printer();
    final Division division =
        new Division(new Constant(new MathNumber(1)), new Constant(new MathNumber(1)));
    printer.visit(division);
    assertEquals(expected, printer.getLastVisitedValue());
    Printer otherPrinter = new Printer();
    division.accept(otherPrinter);
    assertEquals(expected, otherPrinter.getLastVisitedValue());
  }

  @Test
  public void productVisitTest() {
    final String expected = "(1 * 1)";
    final Printer printer = new Printer();
    final Product product =
        new Product(new Constant(new MathNumber(1)), new Constant(new MathNumber(1)));
    printer.visit(product);
    assertEquals(expected, printer.getLastVisitedValue());
    Printer otherPrinter = new Printer();
    product.accept(otherPrinter);
    assertEquals(expected, otherPrinter.getLastVisitedValue());
  }

  @Test
  public void powerVisitTest() {
    final String expected = "(1 ^ 1)";
    final Printer printer = new Printer();
    final Power power = new Power(new Constant(new MathNumber(1)), new Constant(new MathNumber(1)));
    printer.visit(power);
    assertEquals(expected, printer.getLastVisitedValue());
    Printer otherPrinter = new Printer();
    power.accept(otherPrinter);
    assertEquals(expected, otherPrinter.getLastVisitedValue());
  }

  @Test
  public void squareRootVisitTest() {
    final String expected = "1 ^ (1/2)";
    final Printer printer = new Printer();
    final SquareRoot sqrt = new SquareRoot(new Constant(new MathNumber(1)));
    printer.visit(sqrt);
    assertEquals(expected, printer.getLastVisitedValue());
    Printer otherPrinter = new Printer();
    sqrt.accept(otherPrinter);
    assertEquals(expected, otherPrinter.getLastVisitedValue());
  }

  @Test
  public void constantVisitTest() {
    final String expected = "1";
    final Printer printer = new Printer();
    final Constant c = new Constant(new MathNumber(1));
    printer.visit(c);
    assertEquals(expected, printer.getLastVisitedValue());
    Printer otherPrinter = new Printer();
    c.accept(otherPrinter);
    assertEquals(expected, otherPrinter.getLastVisitedValue());
  }

  @Test
  public void variableVisitTest() {
    final String expected = "x";
    final Printer printer = new Printer();
    final Variable x = new Variable("x");
    printer.visit(x);
    assertEquals(expected, printer.getLastVisitedValue());
    Printer otherPrinter = new Printer();
    x.accept(otherPrinter);
    assertEquals(expected, otherPrinter.getLastVisitedValue());
  }

  @Test
  public void variableFunctionVisitTest() {
    final String expected = "x + 1";
    final Printer printer = new Printer();
    final Variable x = new Variable("x");
    final VariableFunction function =
        new VariableFunction(new Addition(x, new Constant(new MathNumber(1))));
    printer.visit(function);
    assertEquals(expected, printer.getLastVisitedValue());
    Printer otherPrinter = new Printer();
    function.accept(otherPrinter);
    assertEquals(expected, otherPrinter.getLastVisitedValue());
  }

  @Test
  public void nonVariableFunctionVisitTest() {
    final String expected = "3 + 1";
    final Printer printer = new Printer();
    final NonVariableFunction function =
        new NonVariableFunction(
            new Addition(new Constant(new MathNumber(3)), new Constant(new MathNumber(1))));
    printer.visit(function);
    assertEquals(expected, printer.getLastVisitedValue());
    Printer otherPrinter = new Printer();
    function.accept(otherPrinter);
    assertEquals(expected, otherPrinter.getLastVisitedValue());
  }

  @Test
  public void absoluteValueVisitTest() {
    final String expected = "|(3 + 1)|";
    final Printer printer = new Printer();
    final NonVariableFunction function =
        new NonVariableFunction(
            new AbsoluteValue(
                new Addition(new Constant(new MathNumber(3)), new Constant(new MathNumber(1)))));
    printer.visit(function);
    assertEquals(expected, printer.getLastVisitedValue());
    Printer otherPrinter = new Printer();
    function.accept(otherPrinter);
    assertEquals(expected, otherPrinter.getLastVisitedValue());
  }
}
