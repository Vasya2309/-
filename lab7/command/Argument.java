package lab7.command;

import java.util.Objects;

public class Argument {
    private String parameter;
    private String value;

    public Argument(String parameter, String value) {
        this.parameter = parameter;
        this.value = value;
    }

    public Argument(String parameter) { this.parameter = parameter; }

    public String getParameter() {
        return parameter;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Argument)) return false;
        Argument argument = (Argument) o;
        return Objects.equals(parameter, argument.parameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parameter);
    }
}
