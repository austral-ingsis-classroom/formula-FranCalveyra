package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.austral.ingsis.math.utils.MathNumber;
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
    final Addition sum =
        new Addition(new Constant(new MathNumber(1)), new Constant(new MathNumber(6)));
    final Double result = sum.solve();

    final NonVariableFunction function = new NonVariableFunction(sum);

    assertThat(result, equalTo(7d));
    assertThat(function.eval(), equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    final Division div =
        new Division(new Constant(new MathNumber(12)), new Constant(new MathNumber(2)));
    final Double result = div.solve();
    final NonVariableFunction function = new NonVariableFunction(div);

    assertThat(result, equalTo(6d));
    assertThat(function.eval(), equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    final Division innerDiv =
        new Division(new Constant(new MathNumber(9)), new Constant(new MathNumber(2)));
    final Product product = new Product(new Constant(new MathNumber(3)), innerDiv);
    final Double result = product.solve();
    final NonVariableFunction function = new NonVariableFunction(product);

    assertThat(result, equalTo(13.5d));
    assertThat(function.eval(), equalTo(13.5d));
    assertEquals(product.solve(), new Product(innerDiv, new Constant(new MathNumber(3))).solve());
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    final Division innerDiv =
        new Division(new Constant(new MathNumber(27)), new Constant(new MathNumber(6)));
    final Power power = new Power(innerDiv, new Constant(new MathNumber(2)));
    final Double result = power.solve();
    final NonVariableFunction function = new NonVariableFunction(power);

    assertThat(result, equalTo(20.25d));
    assertThat(function.eval(), equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    final SquareRoot sqrt = new SquareRoot(new Constant(new MathNumber(36)));
    final Double result = sqrt.solve();
    final NonVariableFunction function = new NonVariableFunction(sqrt);

    assertThat(result, equalTo(6d));
    assertThat(function.eval(), equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    final AbsoluteValue abs = new AbsoluteValue(new Constant(new MathNumber(136)));
    final Double result = abs.solve();
    final NonVariableFunction function = new NonVariableFunction(abs);

    assertThat(result, equalTo(136d));
    assertThat(function.eval(), equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    final AbsoluteValue abs = new AbsoluteValue(new Constant(new MathNumber(-136)));
    final Double result = abs.solve();
    final NonVariableFunction function = new NonVariableFunction(abs);

    assertThat(result, equalTo(136d));
    assertThat(function.eval(), equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Subtraction sub =
        new Subtraction(new Constant(new MathNumber(5)), new Constant(new MathNumber(5)));
    final Product product = new Product(sub, new Constant(new MathNumber(8)));
    final Double result = product.solve();
    final NonVariableFunction function = new NonVariableFunction(sub);

    assertThat(result, equalTo(0d));
    assertThat(function.eval(), equalTo(0d));
  }
}
