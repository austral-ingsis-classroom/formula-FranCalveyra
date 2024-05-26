package edu.austral.ingsis.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.austral.ingsis.math.utils.MathNumber;
import edu.austral.ingsis.math.visitable.function.NonVariableFunction;
import edu.austral.ingsis.math.visitable.function.VariableFunction;
import edu.austral.ingsis.math.visitable.operation.binary.Addition;
import edu.austral.ingsis.math.visitable.operation.binary.Division;
import edu.austral.ingsis.math.visitable.operation.binary.Power;
import edu.austral.ingsis.math.visitable.operation.binary.Product;
import edu.austral.ingsis.math.visitable.operation.binary.Subtraction;
import edu.austral.ingsis.math.visitable.operation.unary.AbsoluteValue;
import edu.austral.ingsis.math.visitable.operation.unary.SquareRoot;
import edu.austral.ingsis.math.visitable.parameter.Constant;
import edu.austral.ingsis.math.visitable.parameter.Variable;
import edu.austral.ingsis.math.visitor.Printer;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    // Function print test
    final String result = "1 + 6";
    final Addition sum =
        new Addition(new Constant(new MathNumber(1)), new Constant(new MathNumber(6)));
    final NonVariableFunction function = new NonVariableFunction(sum);
    final Printer printer = new Printer();
    printer.visit(function);
    assertEquals(result, printer.getLastVisitedValue());
    assertEquals(7, sum.solve());
    // Variable list test
    assertEquals(List.of(), function.listVariables());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    // Function print test
    final String result = "12 / div";
    final VariableFunction function =
        new VariableFunction(new Division(new Constant(new MathNumber(12)), new Variable("div")));
    final Printer printer = new Printer();
    printer.visit(function);
    assertEquals(result, printer.getLastVisitedValue());
    // Variable list test
    assertEquals(List.of("div"), function.listVariables());
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    // Function print test
    final String result = "(9 / x) * y";
    final Division innerDivision = new Division(new Constant(new MathNumber(9)), new Variable("x"));
    final VariableFunction function =
        new VariableFunction(new Product(innerDivision, new Variable("y")));
    final Printer printer = new Printer();
    printer.visit(function);
    assertEquals(result, printer.getLastVisitedValue());
    // Variable list test
    assertEquals(List.of("x", "y"), function.listVariables());
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    // Function print test
    final String result = "(27 / a) ^ b";
    final Division innerDivision =
        new Division(new Constant(new MathNumber(27)), new Variable("a"));
    final VariableFunction function =
        new VariableFunction(new Power(innerDivision, new Variable("b")));
    final Printer printer = new Printer();
    printer.visit(function);
    assertEquals(result, printer.getLastVisitedValue());
    // Variable list test
    assertEquals(List.of("a", "b"), function.listVariables());
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    // Function print test
    final String result = "z ^ (1/2)";
    final SquareRoot sqrt = new SquareRoot(new Variable("z"));
    final VariableFunction function = new VariableFunction(sqrt);
    final Printer printer = new Printer();
    printer.visit(function);
    assertEquals(result, printer.getLastVisitedValue());
    // Variable list test
    assertEquals(List.of("z"), function.listVariables());
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    // Function print test
    final String result = "|value| - 8";
    final AbsoluteValue abs = new AbsoluteValue(new Variable("value"));
    final Subtraction sub = new Subtraction(abs, new Constant(new MathNumber(8)));
    final VariableFunction function = new VariableFunction(sub);
    final Printer printer = new Printer();
    printer.visit(function);
    assertEquals(result, printer.getLastVisitedValue());
    // Variable list test
    assertEquals(List.of("value"), function.listVariables());
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    // Function print test
    final String result = "|value| - 8";
    final AbsoluteValue abs = new AbsoluteValue(new Variable("value"));
    final Subtraction sub = new Subtraction(abs, new Constant(new MathNumber(8)));
    final VariableFunction function = new VariableFunction(sub);
    final Printer printer = new Printer();
    printer.visit(function);
    assertEquals(result, printer.getLastVisitedValue());
    // Variable list test
    assertEquals(List.of("value"), function.listVariables());
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    // Function print test
    final String result = "(5 - i) * 8";
    final Subtraction sub = new Subtraction(new Constant(new MathNumber(5)), new Variable("i"));
    final Product product = new Product(sub, new Constant(new MathNumber(8)));
    final VariableFunction function = new VariableFunction(product);
    final Printer printer = new Printer();
    printer.visit(function);
    assertEquals(result, printer.getLastVisitedValue());
    // Variable list test
    assertEquals(List.of("i"), function.listVariables());
  }
}
