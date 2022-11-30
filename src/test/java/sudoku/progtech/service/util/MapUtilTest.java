package sudoku.progtech.service.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sudoku.progtech.model.MapVO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapUtilTest {

    private MapUtil underTest;

    @BeforeEach
    public void setUp(){
        underTest = new MapUtil();
    }

    @Test
    public void testGetRowOfMapShouldReturnCorrectListWhenCalled(){

        //given
        int[][] values = {
                {0, 1},
                {2, 3}
        };

        MapVO mapVO = new MapVO(2,2,values,null);
        //when
        List<Integer> result = underTest.getRowOfMap(mapVO, 0);

        //then
        List<Integer> expected = List.of(0,1);
        assertEquals(expected, result);
    }

}
