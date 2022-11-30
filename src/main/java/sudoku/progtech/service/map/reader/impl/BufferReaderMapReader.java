package sudoku.progtech.service.map.reader.impl;

import sudoku.progtech.service.exception.MapReadException;
import sudoku.progtech.service.map.reader.MapReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferReaderMapReader implements MapReader {

    private final BufferedReader reader;

    public BufferReaderMapReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public List<String> read() {
        String line;
        List<String> result = new ArrayList<>();

        try {
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            new MapReadException("Failed to read map!");
        }

        return result;
    }
}
