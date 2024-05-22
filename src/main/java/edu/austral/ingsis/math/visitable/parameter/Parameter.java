package edu.austral.ingsis.math.visitable.parameter;

import edu.austral.ingsis.math.utils.MathNumber;

/** Represents a function/operation parameter. */
public interface Parameter {
  MathNumber getValue();

  void setValue(MathNumber value);
}
