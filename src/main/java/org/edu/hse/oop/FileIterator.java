package org.edu.hse.oop;

import java.io.*;
import java.util.Iterator;
import java.util.stream.Collectors;

public class FileIterator implements Iterator<String> {

    private final BufferedReader reader;
//    private FileReader fileReader;

    public FileIterator(InputStream stream) {
        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        reader = new BufferedReader(inputStreamReader);
    }

    public FileIterator(File file) throws FileNotFoundException {
        FileReader fileReader = new FileReader(file);
        reader = new BufferedReader(fileReader);
    }

    public FileIterator(String filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        reader = new BufferedReader(fileReader);
    }

    @Override
    public boolean hasNext() {
        try {
            return reader.ready();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String next() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
