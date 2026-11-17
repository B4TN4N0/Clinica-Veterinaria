package es.centro.veterinaria.modelo;

public class Persona {

    private final String dni;
    private String nombre;
    private int telefono;
    private String email;

    public Persona(String dni, String nombre, int telefono, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    private static boolean esDniValido(String dni) {
        int numero = Integer.parseInt(dni);

    }

    private static void pruebaCommit(){

    }
}
