package edu.escuelaing.arep.awsDocker1.app;
import edu.escuelaing.arep.awsDocker1.app.Service.RequestLog;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class APP_LB_RoundRobin {

    public static void main(String[] args){
        RequestLog requestLog = new RequestLog();

        port(getPort());
        System.out.println(getPort());
        staticFiles.location("/public");

        get("/dataset", (req,res) ->requestLog.getData());

        post("/add",(request, response) -> {
            requestLog.senData(request.body());
            return true;
        });

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 34001;
    }

}