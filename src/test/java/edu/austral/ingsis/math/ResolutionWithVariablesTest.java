package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.visitable.function.VariableFunction;
import edu.austral.ingsis.math.visitable.operation.binary.*;
import edu.austral.ingsis.math.visitable.operation.unary.AbsoluteValue;
import edu.austral.ingsis.math.visitable.operation.unary.SquareRoot;
import edu.austral.ingsis.math.visitable.parameter.Constant;
import edu.austral.ingsis.math.visitable.parameter.Variable;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Variable x = new Variable("x");
    final Addition sum = new Addition(new Constant(1d), x);
    x.setValue(3d);
    final Double result = sum.solve();
    final VariableFunction function = new VariableFunction(sum);

    assertThat(result, equalTo(4d));
    assertThat(function.eval(), equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Variable div = new Variable("div");
    final Division operation = new Division(new Constant(12d), div);
    div.setValue(4d);
    final Double result = operation.solve();
    final VariableFunction function = new VariableFunction(operation);

    assertThat(result, equalTo(3d));
    assertThat(function.eval(), equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Variable x = new Variable("x");
    final Variable y = new Variable("y");
    final Division innerDiv = new Division(new Constant(9d), x);
    final Product product = new Product(innerDiv, y);

    x.setValue(3d);
    y.setValue(4d);

    final Double result = product.solve();
    final VariableFunction function = new VariableFunction(product);

    assertThat(result, equalTo(12d));
    assertThat(function.eval(), equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Variable a = new Variable("a");
    final Variable b = new Variable("b");
    final Division innerDiv = new Division(new Constant(27d), a);
    final Power power = new Power(innerDiv, b);

    a.setValue(9d);
    b.setValue(3d);

    final Double result = power.solve();
    final VariableFunction function = new VariableFunction(power);

    assertThat(result, equalTo(27d));
    assertThat(function.eval(), equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Variable z = new Variable("z");
    final SquareRoot sqrt = new SquareRoot(z);
    z.setValue(36d);

    final Double result = sqrt.solve();
    final VariableFunction function = new VariableFunction(sqrt);

    assertThat(result, equalTo(6d));
    assertThat(function.eval(), equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Variable value = new Variable("value");
    final AbsoluteValue abs = new AbsoluteValue(value);
    final Subtraction sub = new Subtraction(abs, new Constant(8d));

    value.setValue(8d);
    final Double result = sub.solve();
    final VariableFunction function = new VariableFunction(sub);

    assertThat(result, equalTo(0d));
    assertThat(function.eval(), equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Variable value = new Variable("value");
    final AbsoluteValue abs = new AbsoluteValue(value);
    final Subtraction sub = new Subtraction(abs, new Constant(8d));

    value.setValue(8d);
    final Double result = sub.solve();
    final VariableFunction function = new VariableFunction(sub);

    assertThat(result, equalTo(0d));
    assertThat(function.eval(), equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Variable i = new Variable("i");
    final Subtraction sub = new Subtraction(new Constant(5d), i);
    final Product product = new Product(sub, new Constant(8d));

    i.setValue(2d);
    final Double result = product.solve();
    final VariableFunction function = new VariableFunction(product);

    assertThat(result, equalTo(24d));
    assertThat(function.eval(), equalTo(24d));
  }
}
