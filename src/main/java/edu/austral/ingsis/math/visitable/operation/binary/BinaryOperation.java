package edu.austral.ingsis.math.visitable.operation.binary;

import edu.austral.ingsis.math.visitable.operation.Operation;
import edu.austral.ingsis.math.visitor.Visitor;

import java.lang.reflect.Parameter;

public abstract class BinaryOperation implements Operation {
    protected Parameter first;
    protected Parameter second;
    @Override
    public void accept(Visitor visitor) {

    }

    @Override
    public abstract Number solve();
}
