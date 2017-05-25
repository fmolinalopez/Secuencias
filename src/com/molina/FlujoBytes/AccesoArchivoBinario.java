package com.molina.FlujoBytes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Fran on 25/5/17.
 */
public class AccesoArchivoBinario {
    public static void main(String[] args) {
        int bytesImagen[] = new int[1558631];

        try {
            FileInputStream archivoLectura = new FileInputStream("Diablo3.jpg");
            boolean end = false;
            int count = 0;
            // Nº Bytes = 1558631

            while ( !end ){
                int chunk = archivoLectura.read();

                if (chunk == -1) {
                    end = true;
                }else {
                    System.out.println(chunk);
                    bytesImagen[count] = chunk;
                    count++;
                }
            }
            System.out.println("Bytes: " + count);
            archivoLectura.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Copia la imagen Diablo3.jpg a DiabloCopia.jpg
        try {
            FileOutputStream archivoEscritura = new FileOutputStream("DiabloCopia.jpg");

            for (int i = 0; i < bytesImagen.length; i++) {
                archivoEscritura.write(bytesImagen[i]);
            }

            archivoEscritura.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copiarArchivo() {

    }
}
