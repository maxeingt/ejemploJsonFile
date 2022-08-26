import file.ReadFile;
import json.JsonReader;
import model.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Persona diego = new Persona("Diego", "230232232220101", 25, 5500);
        String json = "{ \"name\" : \"Max\", \"dpi\" : \"323422321121\", \"edad\" : \"37\", \"salario\" : \"5500\" }";
        String filePath = "src/main/resources/diego.json";
        String csvPath = "src/main/resources/archivo.csv";
        String urlPath = "file:src/main/resources/diego.json";
        JsonReader jsonReader = new JsonReader();
        ReadFile readCSVFile = new ReadFile();

        logger.info("LEER UN ARCHIVO CSV SIMILAR A LA PRACTICA");
        logger.info("-----------------------------------------");
        String[] lineas = readCSVFile.readFile(csvPath);

        for (String linea : lineas) {
            String[] comp = linea.split(";");
            Persona p = jsonReader.readJsonToObject(comp[1]);

            if (comp[0].equals("INSERT")) {
                logger.info("HACER INSERT EN EL ARBOL");
                logger.info(p.getDpi() + " - " + p.getNombre());
            } else if (comp[0].equals("PATCH")) {
                logger.info("HACER UPDATE EN EL ARBOL");
                logger.info(p.getDpi() + " - " + p.getNombre());
            } else if (comp[0].equals("DELETE")) {
                logger.info("HACER DELETE EN EL ARBOL");
                logger.info(p.getDpi() + " - " + p.getNombre());
            }

        }

        logger.info("EJEMPLO DE CONVERTIR UN OBJETO A JSON Y ESCRIBIR EN ARCHIVO" );
        logger.info("-----------------------------------------");
        jsonReader.readObjectToJsonFile(diego,filePath);

        logger.info("LEER UN ARCHIVO JSON Y CONVERTIRLO A OBJECTO" );
        logger.info("-----------------------------------------");
        Persona p = jsonReader.readFileJsonToObject(filePath);
        logger.info("Nombre: " + p.getNombre() );
        logger.info("Edad: " + p.getEdad() );

        logger.info("LEER UN ARCHIVO JSON DESDE UNA URL Y CONVERTIRLO A OBJECTO" );
        logger.info("-----------------------------------------");
        Persona p2 = jsonReader.readUrlJsonToObject(urlPath);
        logger.info("Nombre: " + p2.getNombre() );
        logger.info("Edad: " + p2.getEdad() );

        logger.info("EJEMPLO DE CONVERTIR JSON A OBJECTO" );
        logger.info("-----------------------------------------");
        Persona p3 = jsonReader.readJsonToObject(json);
        logger.info("Nombre: " + p3.getNombre() );
        logger.info("Edad: " + p3.getEdad() );


    }
}
