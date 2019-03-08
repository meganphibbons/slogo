package nodes.variables;

import apis.ImmutableVisualCommand;
import exceptions.InvalidCommandException;
import exceptions.InvalidInputException;
import exceptions.InvalidVariableException;
import nodes.CommandNode;
import parser.UserCreated;
import turtle.Bale;

import java.util.List;

public class Variable extends CommandNode {
    private String myVarName;
    private double myValue;
    private static final double NOT_ASSIGNED = 0;
    private UserCreated myUserCreated;
    public Variable(String variableName){
        super(variableName);
        myVarName = variableName;
        System.out.println("MADE VARIABLE");
        myValue = NOT_ASSIGNED;
    }
    public Variable(String variableName, UserCreated userCreated) throws InvalidInputException {
        super(variableName);
        System.out.println("MADE VARIABLE" + variableName);
        myVarName = variableName;
        myUserCreated =  userCreated;
    }
    @Override
    public double evaluate(List<ImmutableVisualCommand> myVisCommands, Bale myTurtles) throws InvalidVariableException {
        try {
            myValue = myUserCreated.getValue(myVarName);
            System.out.println("RUNNING: " + myValue);
        }
        catch(Exception e) {
            throw new InvalidVariableException(myVarName);
        }
        return myValue;
    }

//    @Override
}