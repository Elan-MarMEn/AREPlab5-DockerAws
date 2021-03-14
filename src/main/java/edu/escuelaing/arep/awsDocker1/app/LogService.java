package edu.escuelaing.arep.awsDocker1.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import edu.escuelaing.arep.awsDocker1.app.persistence.MongoConnect;

/**
 * Hello world!
 *
 */
public class LogService{

    public static void main(String[] args){
        MongoConnect mongoConnect = new MongoConnect();

        port(getPort());
        staticFiles.location("/public");

        get("/datastore", (req,res) -> mongoConnect.getAlldata());

        post("/add",(request, response) -> {
            mongoConnect.saveData(request.body());
            return true;
        });



    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
}
