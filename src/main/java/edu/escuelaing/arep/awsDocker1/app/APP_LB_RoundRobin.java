package edu.escuelaing.arep.awsDocker1.app;
import edu.escuelaing.arep.awsDocker1.app.Service.RequestLog;

import static spark.Spark.*;

import java.util.List;

/**
 * Hello world!
 *
 */
public class APP_LB_RoundRobin {

    private static String[] subIpsList = {"188.88.0.5","188.88.0.6","188.88.0.7"};
    private static int IPselect = 1;

    public static void main(String[] args){
        RequestLog requestLog = new RequestLog();

        port(getPort());
        System.out.println(getPort());
        staticFiles.location("/public");

        get("/dataset", (req,res) -> requestLog.getData(subIpsList[IPselect%subIpsList.length]));

        post("/add",(request, response) -> {
            requestLog.senData(request.body(),subIpsList[IPselect%subIpsList.length]);
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