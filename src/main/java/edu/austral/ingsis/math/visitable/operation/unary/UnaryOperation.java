package edu.austral.ingsis.math.visitable.operation.unary;

import edu.austral.ingsis.math.visitable.operation.Operation;
import edu.austral.ingsis.math.visitor.Visitor;

import java.lang.reflect.Parameter;

public abstract class UnaryOperation implements Operation {
    protected Parameter parameter;
    @Override
    public void accept(Visitor visitor) {

    }

    @Override
    public abstract Number solve();
}
