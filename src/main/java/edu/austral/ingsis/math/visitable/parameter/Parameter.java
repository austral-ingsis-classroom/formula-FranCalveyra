package edu.austral.ingsis.math.visitable.parameter;

import edu.austral.ingsis.math.utils.MathNumber;
import edu.austral.ingsis.math.visitable.Visitable;

/** Represents a function/operation parameter. */
public interface Parameter extends Visitable {
  MathNumber getValue();

  void setValue(MathNumber value);
}
