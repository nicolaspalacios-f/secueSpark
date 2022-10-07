package edu.escuelaing.app;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        port(getPort());

        secure("keystores/ecikeystore.p12", "profeun5", null, null);
        URLReader.loadTrustStore("keystores/ecikeystore2.p12");
        get("/hello", (req, res) -> "Hello World");
        get("/remote", (req, res) -> URLReader.readURL("https://localhost:5001/bye"));

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

}