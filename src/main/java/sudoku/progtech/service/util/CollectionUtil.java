package sudoku.progtech.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectionUtil {

    public List<Integer> collectNonZeroValues(List<Integer> integerList){
        List<Integer> result = new ArrayList<>();

        for(int value : integerList){
            if (value != 0){
                result.add(value);
            }
        }
        return result;
    }

    /**
     * Checks if a given list only contains distinct values.
     *
     * @param integerList the integer list to check.
     * @return {@code true} if the list only contains distinct values, {@code false} otherwise
     */
    public boolean containsOnlyDistinctValues(List<Integer> integerList){
        Set<Integer> distinctValues = Set.copyOf(integerList);
        return integerList.size() == distinctValues.size();
    }
}
