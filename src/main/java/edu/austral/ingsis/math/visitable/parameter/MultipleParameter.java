package edu.austral.ingsis.math.visitable.parameter;

import java.util.List;

public class MultipleParameter implements Parameter{
    private List<Parameter> parameters;
    public MultipleParameter(List<Parameter> parameters){
        this.parameters = parameters;
    }

    @Override
    public void setValue(Parameter parameter) {
        //TODO: implement
    }
}
