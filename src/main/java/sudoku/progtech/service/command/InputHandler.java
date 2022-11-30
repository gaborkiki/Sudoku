package sudoku.progtech.service.command;

import java.util.List;

public class InputHandler {

    private List<Command> commandList;

    public InputHandler(List<Command> commandList) {
        this.commandList = commandList;
    }

    public void handleInput(String input){
        for(Command command : commandList){
            if(command.canProcess(input)){
                command.canProcess(input);
            }
        }
    }
}
