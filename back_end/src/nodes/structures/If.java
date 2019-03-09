package nodes.structures;
import apis.ImmutableVisualCommand;
import exceptions.InvalidInputException;
import nodes.CommandNode;
import turtle.Bale;

import java.util.List;

public class If extends CommandNode {
    private static final int FALSE_PATH = 2;
    private static final int IF_STATEMENT= 0;
    private static final int TRUE_PATH = 1;


    public If(String a) {
        super(a);
    }

    @Override
    public double evaluate(List<ImmutableVisualCommand> myVisCommands, Bale myTurtles) throws InvalidInputException {
        double result = super.getChildren().get(IF_STATEMENT).evaluate(myVisCommands, myTurtles);
        if (result != 0){
            return super.getChildren().get(TRUE_PATH).evaluate(myVisCommands, myTurtles);
        }
        else{
            return FALSE_PATH;
        }
    }

    @Override
    public void addChild(CommandNode c) {
        if (super.getChildren().size() == 3) {
            throw new IllegalArgumentException();
        }
        super.addChild(c);
    }
}