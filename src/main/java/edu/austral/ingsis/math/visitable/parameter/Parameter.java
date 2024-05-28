package edu.austral.ingsis.math.visitable.parameter;

import edu.austral.ingsis.math.visitable.Visitable;

/** Represents a function/operation parameter. */
public interface Parameter extends Visitable {
  Double getValue();

  void setValue(Double value);
}
