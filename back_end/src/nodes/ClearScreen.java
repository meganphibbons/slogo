package nodes;

import apis.ImmutableVisualCommand;
import turtle.Bale;
import turtle.Turtle;

import java.util.List;

public class ClearScreen extends CommandNode {
    public ClearScreen(String name){
        super(name);
    }
    /**
     * TODO - Use immutable turtle state to get current coordinates to return distance moved to go home
     */
    @Override
    public double evaluate(List<ImmutableVisualCommand> myVisCommands, Bale myTurtles) {
        for (Turtle t: myTurtles){
            t.setXCoor(0);
            t.setYCoor(0);
            t.setHeading(0);
        }

        myVisCommands.add(new VisualClearScreen());
        return 0;
    }
    @Override
    public void addChild(CommandNode c){
        throw new IllegalArgumentException();
    }
}
