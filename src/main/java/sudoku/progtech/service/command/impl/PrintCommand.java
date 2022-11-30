package sudoku.progtech.service.command.impl;

import sudoku.progtech.service.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PrintCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintCommand.class);

    @Override
    public boolean canProcess(String input) {
        return true;
    }

    @Override
    public void process(String input) {
        LOGGER.info("PROCESSING");
    }
}
