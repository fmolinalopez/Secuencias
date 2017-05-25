package com.molina.EscrituraEnArchivo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Fran on 24/5/17.
 */
public class GuardarArchivopTexto {
    public static void main(String[] args) {
        EscribirArchivoCaracteres escribiendo = new EscribirArchivoCaracteres();

        escribiendo.write();
    }
}

class EscribirArchivoCaracteres {
    public void write() {
        String texto = "Cuando el grajo vuela bajo y hace frio del ...";

        try {
            FileWriter fw = new FileWriter("escanfor.txt");

            for (int i = 0; i < texto.length(); i++) {
                fw.write(texto.charAt(i));
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
