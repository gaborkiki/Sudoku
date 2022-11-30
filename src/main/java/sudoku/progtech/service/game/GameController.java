package sudoku.progtech.service.game;

import sudoku.progtech.model.GameState;
import sudoku.progtech.service.util.MapUtil;

public class GameController {

    private GameState gameState;
    private MapUtil mapUtil;
    private GameStepPerformer gameStepPerformer;

    public GameController(GameState gameState, MapUtil mapUtil, GameStepPerformer gameStepPerformer) {
        this.gameState = gameState;
        this.mapUtil = mapUtil;
        this.gameStepPerformer = gameStepPerformer;
    }

    public void gameLoop(){
        while (isGameInProgress()){
            gameStepPerformer.performGameStep();
        }
    }

    private boolean isGameInProgress(){
        return !mapUtil.isMapCompleted(gameState.getMapVO()) && !gameState.isUserWantsToExit();
    }
}
