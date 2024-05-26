package edu.austral.ingsis.math.visitable.operation;

import edu.austral.ingsis.math.visitable.Visitable;
import edu.austral.ingsis.math.visitable.parameter.Parameter;
import java.util.List;

public interface Operation extends Visitable, Parameter {
  Double solve();

  List<Parameter> getParameters();
}
