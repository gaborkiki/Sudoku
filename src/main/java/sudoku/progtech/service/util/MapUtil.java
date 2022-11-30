package sudoku.progtech.service.util;

import sudoku.progtech.model.MapVO;

import java.util.ArrayList;
import java.util.List;

public class MapUtil {

    public List<Integer> getRowOfMap(MapVO mapVO, int rowIndex){
        List<Integer> result = new ArrayList<>();

        int[][] map= mapVO.getValues();
        for(int i=0;i<mapVO.getNumberOfColumns();i++){
            result.add(map[rowIndex][i]);
        }
        return result;
    }

    public boolean isMapCompleted(MapVO mapVO){
        boolean result = true;

        int[][] map = mapVO.getValues();
        for(int[] row:map) {
            for(int number: row){
                if(number == 0){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
