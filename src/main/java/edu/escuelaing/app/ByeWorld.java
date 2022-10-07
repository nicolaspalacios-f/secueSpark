package edu.escuelaing.app;

import static spark.Spark.*;

public class ByeWorld {
    public static void main(String[] args) {
        port(getPort());

        secure(getKeyStore(), getKeyStorePassword(), null, null);
        URLReader.loadTrustStore(getTrustStore());
        get("/bye", (req, res) -> getOwner() + " World");
        get("/remote", (req, res) -> URLReader.readURL(getLink()));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }

    static String getKeyStorePassword() {
        if (System.getenv("KEYSTOREPWD") != null) {
            return System.getenv("KEYSTOREPWD");
        }
        return "profeun5";
    }

    static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "keystores/ecikeystore2.p12";
    }

    static String getTrustStorePassword() {
        if (System.getenv("TRUSTSTORE") != null) {
            return System.getenv("TRUSTSTOREPWD");
        }
        return "profeun5";
    }

    static String getTrustStore() {
        if (System.getenv("TRUSTSTORE") != null) {
            return System.getenv("TRUSTSTORE");
        }
        return "./keystores/ecikeystore.p12";
    }

    static String getLink() {
        if (System.getenv("LINK") != null) {
            return System.getenv("LINK");
        }
        return "https://localhost:5000/hello";
    }

    static String getOwner() {
        if (System.getenv("OWNER") != null) {
            return System.getenv("OWNER");
        }
        return "no";
    }
}
