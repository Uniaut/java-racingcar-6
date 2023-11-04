package racingcar.controller;

import java.util.List;
import racingcar.dto.ConsoleInput;
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

    private ConsoleInput carNamesInput;
    private ConsoleInput numberAttemptsInput;

    private Race race;

    public GameController() {
        gameView = new GameView();
        raceView = new RaceView();
    }

    private void askSettings() {
        carNamesInput = gameView.askCarNames();
        numberAttemptsInput = gameView.askNumberAttempts();
    }

    private void readyRace() {
        InputHandler<List<String>> carNamesHandler = new InputHandler<>(
                new CarNamesValidator(), new CarNamesParser());

        List<String> carNames = carNamesHandler.handle(carNamesInput);

        race = new Race(carNames);
    }

    private void runRace() {
        InputHandler<Integer> numberAttemptsHandler = new InputHandler<>(
                new NumberAttemptsValidator(), new NumberAttemptsParser());

        Integer numberAttempts = numberAttemptsHandler.handle(numberAttemptsInput);

        raceView.printRaceIntro();
        for (int i = 0; i < numberAttempts; i++) {
            race.doAttempt();
            raceView.printRace(race);
        }
        raceView.printWinner(race);
    }

    public void run() {
        askSettings();

        readyRace();

        runRace();
    }
}
