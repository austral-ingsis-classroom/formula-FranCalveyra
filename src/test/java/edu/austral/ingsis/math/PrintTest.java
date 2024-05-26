package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.utils.MathNumber;
import edu.austral.ingsis.math.visitable.function.NonVariableFunction;
import edu.austral.ingsis.math.visitable.function.VariableFunction;
import edu.austral.ingsis.math.visitable.operation.binary.*;
import edu.austral.ingsis.math.visitable.operation.unary.AbsoluteValue;
import edu.austral.ingsis.math.visitable.parameter.Constant;
import edu.austral.ingsis.math.visitable.parameter.Variable;
import edu.austral.ingsis.math.visitor.Printer;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    final Addition sum =
        new Addition(new Constant(new MathNumber(1)), new Constant(new MathNumber(6)));
    final NonVariableFunction function = new NonVariableFunction(sum);
    final Printer printer = new Printer();
    printer.visit(function);
    final String result = printer.getLastVisitedValue();
    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    final Division div =
        new Division(new Constant(new MathNumber(12)), new Constant(new MathNumber(2)));
    final NonVariableFunction function = new NonVariableFunction(div);
    final Printer printer = new Printer();
    printer.visit(function);
    final String result = printer.getLastVisitedValue();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    final Division innerDiv =
        new Division(new Constant(new MathNumber(9)), new Constant(new MathNumber(2)));
    final Product product = new Product(innerDiv, new Constant(new MathNumber(3)));
    final NonVariableFunction function = new NonVariableFunction(product);
    final Printer printer = new Printer();
    printer.visit(function);
    final String result = printer.getLastVisitedValue();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    final Division innerDiv =
        new Division(new Constant(new MathNumber(27)), new Constant(new MathNumber(6)));
    final Power power = new Power(innerDiv, new Constant(new MathNumber(2)));
    final NonVariableFunction function = new NonVariableFunction(power);
    final Printer printer = new Printer();
    printer.visit(function);
    final String result = printer.getLastVisitedValue();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    final AbsoluteValue abs = new AbsoluteValue(new Variable("value"));
    final Subtraction sub = new Subtraction(abs, new Constant(new MathNumber(8)));
    final VariableFunction function = new VariableFunction(sub);
    final Printer printer = new Printer();
    printer.visit(function);
    final String result = printer.getLastVisitedValue();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    final AbsoluteValue abs = new AbsoluteValue(new Variable("value"));
    final Subtraction sub = new Subtraction(abs, new Constant(new MathNumber(8)));
    final VariableFunction function = new VariableFunction(sub);
    final Printer printer = new Printer();
    printer.visit(function);
    final String result = printer.getLastVisitedValue();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    final Subtraction subtraction =
        new Subtraction(new Constant(new MathNumber(5)), new Variable("i"));
    final Product product = new Product(subtraction, new Constant(new MathNumber(8)));
    final VariableFunction function = new VariableFunction(product);
    final Printer printer = new Printer();
    printer.visit(function);
    final String result = printer.getLastVisitedValue();

    assertThat(result, equalTo(expected));
  }

  @Test
  public void shouldPrintFunction9() {
    final String expected = "|x|";
    final AbsoluteValue abs = new AbsoluteValue(new Variable("x"));
    final Printer printer = new Printer();
    printer.visit(abs);
    final String result = printer.getLastVisitedValue();
    assertThat(result, equalTo(expected));
  }
}
