package com.molina.LecturaCaracteresBuffers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Fran on 24/5/17.
 */
public class LeerArchivoConBuffer {
    public static void main(String[] args) {
        LeerFicheroConBuffer lfcb = new LeerFicheroConBuffer();

        lfcb.leer();
    }
}

class LeerFicheroConBuffer {

    public void leer() {
        Date inicio = new Date();
        try {
            FileReader fichero = new FileReader("prueba.txt");

            BufferedReader buffer = new BufferedReader(fichero);

            String linea;

            while ((linea = buffer.readLine()) != null ) {
                System.out.println(linea);
                linea = buffer.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Date fin = new Date();

        long tiempo = fin.getTime()-inicio.getTime();

        System.out.println("Tiempo transcurrido: " + tiempo);
    }
}
