package lab7.command;

import lab7.exception.RequiredParameterException;

import java.util.List;

public abstract class Command {
    String command;
    List<Argument> arguments;
    Object target;

    public Command(String command, List<Argument> arguments, Object target) {
        this.command = command;
        this.arguments = arguments;
        this.target = target;
    }

    public Command(String command) {
        this.command = command;
    }

    public Command() { }

    public abstract void execute() throws RequiredParameterException;

    protected String getValueByParameter(String parameter) throws RequiredParameterException {
        int index = arguments.indexOf(new Argument(parameter));
        if (index == -1) {
            throw new RequiredParameterException(parameter);
        }
        return arguments.get(index).getValue();
    }

    protected boolean containsValueByParameter(String parameter) {
        int index = arguments.indexOf(new Argument(parameter));
        if (index == -1) {
            return false;
        }
        return true;
    }
}
