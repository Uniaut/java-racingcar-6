package racingcar.model;

public class InputHandler<T> {
    private final InputValidator inputValidator;
    private final InputParser<T> inputParser;

    public InputHandler(InputValidator inputValidator, InputParser<T> inputParser) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }

    public T handle(String input) {
        inputValidator.validate(input);
        return inputParser.parse(input);
    }
}
