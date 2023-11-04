package racingcar.model;

public class InputHandler {
    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public InputHandler(InputValidator inputValidator, InputParser inputParser) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }

    public Object handle(String input) {
        inputValidator.validate(input);
        return inputParser.parse(input);
    }
}
