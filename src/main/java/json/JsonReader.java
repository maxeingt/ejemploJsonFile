package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsonReader {

    private static Logger logger = LogManager.getLogger(JsonReader.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    public void readObjectToJsonFile(Persona persona, String filePath) {

        try {
            objectMapper.writeValue(new File(filePath), persona);
        } catch (IOException e) {
            logger.error("Error durante creacion del archivo Json");
        }
    }

    public Persona readJsonToObject(String json) {
        try {
            return objectMapper.readValue(json, Persona.class);
        } catch (JsonProcessingException e) {
            logger.error("Error durante el parseo del Json");
        }
        return null;
    }

    public Persona readFileJsonToObject(String jsonPath) {
        try {
            return objectMapper.readValue(new File(jsonPath), Persona.class);
        } catch (JsonProcessingException e) {
            logger.error("Error durante el parseo del Json");
        } catch (IOException e) {
            logger.error("Error durante la lectura del archivo");
        }
        return null;
    }

    public Persona readUrlJsonToObject(String jsonUrl) {
        try {
            return objectMapper.readValue(new URL(jsonUrl), Persona.class);
        } catch (JsonProcessingException e) {
            logger.error("Error durante el parseo del Json");
        } catch (IOException e) {
            logger.error("Error durante la lectura del archivo");
        }
        return null;
    }
}
