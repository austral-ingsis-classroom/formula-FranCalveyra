package edu.austral.ingsis.math.visitable.function;

import edu.austral.ingsis.math.visitable.Visitable;
import java.util.List;

public interface Function extends Visitable {
  Double eval();

  List<String> listVariables();
}
