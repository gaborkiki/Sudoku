package sudoku.progtech.service.game;

import sudoku.progtech.service.command.InputHandler;
import sudoku.progtech.service.input.UserInputReader;

public class GameStepPerformer {

    private UserInputReader userInputReader;
    private InputHandler inputHandler;

    public GameStepPerformer(UserInputReader userInputReader, InputHandler inputHandler) {
        this.userInputReader = userInputReader;
        this.inputHandler = inputHandler;

    }

    public void performGameStep(){
        String input = userInputReader.readInput();
        inputHandler.handleInput(input);
    }
}
