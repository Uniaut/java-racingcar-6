package racingcar.controller;

import java.util.List;
import racingcar.model.CarNamesParser;
import racingcar.model.CarNamesValidator;
import racingcar.model.InputHandler;
import racingcar.model.NumberAttemptsParser;
import racingcar.model.NumberAttemptsValidator;
import racingcar.model.Race;
import racingcar.view.GameView;
import racingcar.view.RaceView;

public class GameController {

    private final GameView gameView;
    private final RaceView raceView;

    public GameController() {
        gameView = new GameView();
        raceView = new RaceView();
    }

    public void run() {
        String carNamesInput = gameView.askCarNames();
        String numberAttemptsInput = gameView.askNumberAttempts();

        InputHandler<List<String>> carNamesHandler = new InputHandler<>(new CarNamesValidator(), new CarNamesParser());
        InputHandler<Integer> numberAttemptsHandler = new InputHandler<>(new NumberAttemptsValidator(),
                new NumberAttemptsParser());

        List<String> carNames = carNamesHandler.handle(carNamesInput);
        Integer numberAttempts = numberAttemptsHandler.handle(numberAttemptsInput);

        Race race = new Race(carNames);

        raceView.printRaceIntro();
        for (int i = 0; i < numberAttempts; i++) {
            race.doAttempt();
            raceView.printRace(race);
        }
        raceView.printWinner(race);
    }
}
