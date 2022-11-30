package sudoku.progtech.model;

import java.util.Objects;
import java.util.StringJoiner;

public class GameState {

    private MapVO mapVO;
    private boolean UserWantsToExit;

    public GameState(MapVO mapVO, boolean userWantsToExit) {
        this.mapVO = mapVO;
        UserWantsToExit = userWantsToExit;
    }

    public MapVO getMapVO() {
        return mapVO;
    }

    public void setMapVO(MapVO mapVO) {
        this.mapVO = mapVO;
    }

    public boolean isUserWantsToExit() {
        return UserWantsToExit;
    }

    public void setUserWantsToExit(boolean userWantsToExit) {
        UserWantsToExit = userWantsToExit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameState gameState = (GameState) o;
        return UserWantsToExit == gameState.UserWantsToExit && mapVO.equals(gameState.mapVO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapVO, UserWantsToExit);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", GameState.class.getSimpleName() + "[", "]")
                .add("mapVO=" + mapVO)
                .add("UserWantsToExit=" + UserWantsToExit)
                .toString();
    }
}
