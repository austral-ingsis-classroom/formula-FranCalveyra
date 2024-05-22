package edu.austral.ingsis.math.visitable;

import edu.austral.ingsis.math.visitor.Visitor;

public interface Visitable {
  void accept(Visitor visitor);
}
