package lab7.exception;

public class RequiredParameterException extends Throwable {
    private final String parameterName;

    public RequiredParameterException(String parameter) {
        super();
        this.parameterName = parameter;
    }

    public String getParameterName() {
        return parameterName;
    }
}
