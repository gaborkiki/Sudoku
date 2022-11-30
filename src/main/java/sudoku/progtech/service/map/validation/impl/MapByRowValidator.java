package sudoku.progtech.service.map.validation.impl;

import sudoku.progtech.model.MapVO;
import sudoku.progtech.service.exception.MapValidationException;
import sudoku.progtech.service.map.validation.MapValidator;
import sudoku.progtech.service.util.CollectionUtil;
import sudoku.progtech.service.util.MapUtil;

import java.util.List;

public class MapByRowValidator implements MapValidator {

    private final MapUtil mapUtil;
    private final CollectionUtil collectionUtil;

    public MapByRowValidator(MapUtil mapUtil, CollectionUtil collectionUtil) {
        this.mapUtil = mapUtil;
        this.collectionUtil = collectionUtil;
    }

    @Override
    public void validate(MapVO mapVO) {
        int numberOfRows = mapVO.getNumberOfRows();

        for (int i = 0; i < numberOfRows; i++){
            List<Integer> rowOfMap = mapUtil.getRowOfMap(mapVO, i);
            List<Integer> nonZeroValues = collectionUtil.collectNonZeroValues(rowOfMap);
            if (!collectionUtil.containsOnlyDistinctValues(nonZeroValues)){
                throw new MapValidationException("Invalid Row!");
            }
        }
    }
}
