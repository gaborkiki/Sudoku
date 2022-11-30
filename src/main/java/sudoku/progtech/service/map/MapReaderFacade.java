package sudoku.progtech.service.map;

import sudoku.progtech.model.MapVO;
import sudoku.progtech.service.exception.MapReadException;
import sudoku.progtech.service.map.parser.MapParser;
import sudoku.progtech.service.map.reader.MapReader;
import sudoku.progtech.service.map.validation.MapValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MapReaderFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapReaderFacade.class);
    private final MapReader mapReader;
    private final MapParser mapParser;
    private final MapValidator mapValidator;

    public MapReaderFacade(MapReader mapReader, MapParser mapParser, MapValidator mapValidator){
        this.mapReader = mapReader;
        this.mapParser = mapParser;
        this.mapValidator = mapValidator;
    }

    public MapVO readMap() {
        MapVO result;

        try{
            List<String> rawMap = mapReader.read();
            result = mapParser.parse(rawMap);
            mapValidator.validate(result);
        }catch(MapReadException e){
            LOGGER.error("Failed to read map!");
            throw new RuntimeException("Failed to read map!");
        }catch(RuntimeException e){
            LOGGER.error("Unknown exception!", e);
            throw new RuntimeException("Unknown exception!");
        }

        return result;
    }
}
