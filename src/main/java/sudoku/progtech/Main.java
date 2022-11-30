package sudoku.progtech;

import sudoku.progtech.model.MapVO;
import sudoku.progtech.service.map.MapReaderFacade;
import sudoku.progtech.service.map.parser.MapParser;
import sudoku.progtech.service.map.reader.MapReader;
import sudoku.progtech.service.map.reader.impl.BufferReaderMapReader;
import sudoku.progtech.service.map.validation.MapValidator;
import sudoku.progtech.service.map.validation.impl.MapByRowValidator;
import sudoku.progtech.service.util.CollectionUtil;
import sudoku.progtech.service.util.MapUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("map/beginner.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        MapReader mapReader = new BufferReaderMapReader(reader);
        //List<String> rawMap = mapReader.read();

        MapParser mapParser = new MapParser( 9,9);
        //MapVO mapVO = mapParser.parse(rawMap);

        MapUtil mapUtil = new MapUtil();
        CollectionUtil collectionUtil = new CollectionUtil();
        MapValidator mapValidator = new MapByRowValidator(mapUtil, collectionUtil);

        MapReaderFacade mapReaderFacade = new MapReaderFacade(mapReader, mapParser, mapValidator);
        MapVO mapVO = mapReaderFacade.readMap();

        System.out.println(mapVO);
    }
}