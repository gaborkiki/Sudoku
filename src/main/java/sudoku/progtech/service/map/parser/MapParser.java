package sudoku.progtech.service.map.parser;

import sudoku.progtech.model.MapVO;
import sudoku.progtech.service.exception.MapParseException;

import java.util.List;

public class MapParser {

    private final int numberOfRows;
    private final int numberOfColumns;

    public MapParser(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }


    public MapVO parse(List<String> rawMap) {
        checkNumberOfRows(rawMap);

        int[][] values = getValues(rawMap);
        boolean [][] fixed = getFixed(values);

        return new MapVO(numberOfRows,numberOfColumns,values,fixed);
    }

    private int [][] getValues(List<String> rawMap){
        int[][] result = new int[numberOfRows][];

        for(int i=0;i<numberOfRows;i++){
            result[i] = new int[numberOfColumns];

            String row = rawMap.get(i);
            String[] numberAsString = row.split("");

            for(int j=0;j<numberOfColumns;j++){
                int n = Integer.parseInt(numberAsString[j]);
                result[i][j] = n;
            }
        }

        return result;
    }

    private boolean[][] getFixed(int[][] map) {
        boolean[][] fixed = new boolean[numberOfRows][numberOfColumns];

        for(int x = 0; x < numberOfRows; x++){
            for (int y = 0; y < numberOfColumns; y++){
                fixed[x][y] = map[x][y] !=0;
            }
        }
        return fixed;
    }

    private void checkNumberOfRows(List<String> rawMap){
        if(rawMap.size() != numberOfRows){
            throw new MapParseException("Number of rows was incorrect, it was" + rawMap.size());
        }
    }
}
