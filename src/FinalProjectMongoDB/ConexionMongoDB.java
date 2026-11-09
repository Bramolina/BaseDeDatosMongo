package FinalProjectMongoDB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexionMongoDB {

    static MongoClient mongoClient;
    static MongoDatabase database;

    public static MongoDatabase conectar() {

        if (mongoClient == null) {

            mongoClient = MongoClients.create("mongodb://localhost:27017");

            database = mongoClient.getDatabase("TrainTicketSystem");

            System.out.println("Conexion exitosa con MongoDB");
        }

        return database;
    }
}