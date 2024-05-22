package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitable.function.Function;
import edu.austral.ingsis.math.visitable.operation.Operation;
import edu.austral.ingsis.math.visitable.parameter.Parameter;

public interface Visitor {
    void visit(Function function);
    void visit(Parameter parameter);
    void visit(Operation operation);
    //TODO: use the rest of actual CLASSES, not interface delegations
}
