package edu.austral.ingsis.math.visitable.parameter;

public class Constant implements Parameter{
    private Number value;
    public Constant(Number val){
        value = val;
    }

    @Override
    public void setValue(Parameter parameter) {
        //TODO: implement
    }
}
