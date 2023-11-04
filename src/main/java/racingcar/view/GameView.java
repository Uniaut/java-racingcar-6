package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarNamesParser;
import racingcar.model.CarNamesValidator;
import racingcar.model.InputHandler;
import racingcar.model.NumberAttemptsParser;
import racingcar.model.NumberAttemptsValidator;

public class GameView {
    private final InputHandler carNamesHandler;
    private final InputHandler numberAttemptsHandler;

    public GameView() {
        carNamesHandler = new InputHandler(
                new CarNamesValidator(), new CarNamesParser());
        numberAttemptsHandler = new InputHandler(
                new NumberAttemptsValidator(), new NumberAttemptsParser());
    }

    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String askNumberAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
