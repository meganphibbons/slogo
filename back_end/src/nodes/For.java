package nodes;

import apis.AddVariable;
import apis.ImmutableVisualCommand;
import turtle.Bale;

import java.util.List;

public class For extends CommandNode{
    private static final int ITERATOR = 0;
    private static final int START = 1;
    private static final int END = 2;
    private static final int INCREMENT = 3;
    private static final int LISTNODE = 4;
    private AddVariable myAddVarFunction;

    public For(String a){
        super(a);
    }
    public For(String a, AddVariable add) {
        super(a);
        myAddVarFunction = add;
    }

    @Override
    public double evaluate(List<ImmutableVisualCommand> myVisCommands, Bale myTurtles) {
        String name = super.getChildren().get(ITERATOR).getName();
        double start = super.getChildren().get(START).evaluate(myVisCommands,myTurtles);
        myAddVarFunction.addNewVariable(name,start);


        double end = super.getChildren().get(END).evaluate(myVisCommands,myTurtles);
        double increment = super.getChildren().get(INCREMENT).evaluate(myVisCommands,myTurtles);

        //need to verify that these values will not cause an infinite loop
        if ( (start < end & increment <= 0) |  (start > end & increment >= 0))
            throw new IllegalArgumentException();

        double ret = 0;
        while (start < end) {
            ret = super.getChildren().get(LISTNODE).evaluate(myVisCommands,myTurtles);
            start += increment;
            myAddVarFunction.addNewVariable(name,start);
        }
        return ret;
    }
}