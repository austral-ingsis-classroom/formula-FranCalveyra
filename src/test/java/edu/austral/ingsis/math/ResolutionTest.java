package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.austral.ingsis.math.visitable.function.NonVariableFunction;
import edu.austral.ingsis.math.visitable.operation.binary.*;
import edu.austral.ingsis.math.visitable.operation.unary.AbsoluteValue;
import edu.austral.ingsis.math.visitable.operation.unary.SquareRoot;
import edu.austral.ingsis.math.visitable.parameter.Constant;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    final Addition sum = new Addition(new Constant(1d), new Constant(6d));
    final Double result = sum.solve();

    final NonVariableFunction function = new NonVariableFunction(sum);

    assertThat(result, equalTo(7d));
    assertThat(function.eval(), equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Division div = new Division(new Constant(12d), new Constant(2d));
    final Double result = div.solve();
    final NonVariableFunction function = new NonVariableFunction(div);

    assertThat(result, equalTo(6d));
    assertThat(function.eval(), equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Division innerDiv = new Division(new Constant(9d), new Constant(2d));
    final Product product = new Product(new Constant(3d), innerDiv);
    final Double result = product.solve();
    final NonVariableFunction function = new NonVariableFunction(product);

    assertThat(result, equalTo(13.5d));
    assertThat(function.eval(), equalTo(13.5d));
    assertEquals(product.solve(), new Product(innerDiv, new Constant(3d)).solve());
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Division innerDiv = new Division(new Constant(27d), new Constant(6d));
    final Power power = new Power(innerDiv, new Constant(2d));
    final Double result = power.solve();
    final NonVariableFunction function = new NonVariableFunction(power);

    assertThat(result, equalTo(20.25d));
    assertThat(function.eval(), equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final SquareRoot sqrt = new SquareRoot(new Constant(36d));
    final Double result = sqrt.solve();
    final NonVariableFunction function = new NonVariableFunction(sqrt);

    assertThat(result, equalTo(6d));
    assertThat(function.eval(), equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final AbsoluteValue abs = new AbsoluteValue(new Constant(136d));
    final Double result = abs.solve();
    final NonVariableFunction function = new NonVariableFunction(abs);

    assertThat(result, equalTo(136d));
    assertThat(function.eval(), equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final AbsoluteValue abs = new AbsoluteValue(new Constant(-136d));
    final Double result = abs.solve();
    final NonVariableFunction function = new NonVariableFunction(abs);

    assertThat(result, equalTo(136d));
    assertThat(function.eval(), equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Subtraction sub = new Subtraction(new Constant(5d), new Constant(5d));
    final Product product = new Product(sub, new Constant(8d));
    final Double result = product.solve();
    final NonVariableFunction function = new NonVariableFunction(sub);

    assertThat(result, equalTo(0d));
    assertThat(function.eval(), equalTo(0d));
  }
}
