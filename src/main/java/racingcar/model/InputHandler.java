package racingcar.model;

import racingcar.dto.ConsoleInput;

public class InputHandler<T> {
    private final InputValidator inputValidator;
    private final InputParser<T> inputParser;

    public InputHandler(InputValidator inputValidator, InputParser<T> inputParser) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }

    public T handle(ConsoleInput input) {
        inputValidator.validate(input.input());
        return inputParser.parse(input.input());
    }
}
