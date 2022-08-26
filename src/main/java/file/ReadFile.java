package file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    private static Logger logger = LogManager.getLogger(ReadFile.class);

    public String[] readFile(String pathFile) {

        String[] result = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            result = reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            logger.error("Error durante la lectura del archivo.");
        }

        return result;
    }
}
