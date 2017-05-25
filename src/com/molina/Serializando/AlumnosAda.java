package com.molina.Serializando;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Fran on 25/5/17.
 */
public class AlumnosAda {
    public static void main(String[] args) {
        ArrayList<Persona> primeroDAW;// = new ArrayList<>();
//
//        primeroDAW.add( new Persona("Fran","Delgado","666W" ));
//        primeroDAW.add( new Alumno( "Sergio", "Asuero", "555W", "2017"));
//        primeroDAW.add( new Alumno( "Adrian", "Morcillo", "444W", "2017"));
//        primeroDAW.add( new Alumno( "Joaquín", "García", "333W", "2017"));
//        primeroDAW.add( new Alumno( "Juanjo", "Villalba", "101010W", "2017"));
//
//
//        // Guardar el archivo
//
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream( "Curso.dat"));
//            oos.writeObject( primeroDAW );
//
//            oos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        // Leer el archivo

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Curso.dat"));

            primeroDAW = (ArrayList<Persona>) ois.readObject();

            for (Persona persona: primeroDAW) {
                System.out.println(persona);
            }

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

class Persona implements Serializable {

    // Atributos
    private static final long serialVersionUID = -2362951856578729759L;

    String nombre;
    String apellidos;
    String dni;
    boolean esAlto;

    // Constructores

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        esAlto = true;
    }

    // Metodos

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    // Accesores

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}


class Alumno extends Persona {

    // Atributos

    String curso;

    // Constructores

    public Alumno(String nombre, String apellidos, String dni, String curso) {
        super(nombre, apellidos, dni);
        this.curso = curso;
        esAlto = false;
    }

    // Metodos

    @Override
    public String toString() {
        return super.toString() +
                "curso='" + curso + '\'' +
                '}';
    }

    // Accesores

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}