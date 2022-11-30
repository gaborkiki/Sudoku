package sudoku.progtech.service.command;

public interface Command {

    boolean canProcess(String input);

    void process(String input);

}
