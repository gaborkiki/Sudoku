package sudoku.progtech.service.command.impl;

import sudoku.progtech.service.command.Command;

public class ExitCommand implements Command {

    @Override
    public boolean canProcess(String input) {
        return false;
    }

    @Override
    public void process(String input) {

    }
}
