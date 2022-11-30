package sudoku.progtech.service.command.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sudoku.progtech.model.GameState;
import sudoku.progtech.service.command.Command;

public class ExitCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExitCommand.class);

    private static final String EXIT_COMMAND = "exit";

    private GameState gameState;

    public ExitCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public boolean canProcess(String input) {
        return EXIT_COMMAND.equals(input);
    }

    @Override
    public void process(String input) {
        LOGGER.info("Setting exit flag to true");
        gameState.setUserWantsToExit(true);
    }
}
