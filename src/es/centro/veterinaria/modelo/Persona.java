package es.centro.veterinaria.modelo;

public class Persona {
    private final String dni;
    private String nombre = "Jane Doe";
    private String telefono = "000000000";
    private String email = "default@def.es";

    public Persona(String dni, String nombre, String telefono, String email) {
        dni = transformarDniMayusculas(dni);
        nombre = capitalizarNombre(nombre);

        if (esDniValido(dni) && esTelefonoValido(telefono) && esEmailValido(email)
                && !(nombre == null || nombre.isEmpty())) {
            this.nombre = nombre;
            this.email = email;
            this.telefono = telefono;
            System.out.println("Persona registrada correctamente.");
        } else {
            if (!esDniValido(dni)) {
                System.out.println(
                        "CUIDADO: El DNI aportado no es válido. Se ha establecido el valor aportado, pero puede que algunas funciones del programa fallen.");
            }
            if (nombre == null || nombre.isEmpty()) {
                System.out
                        .println(
                                "CUIDADO: El nombre no ha sido ingresado correctamente. Se ha establecido el valor por defecto.");
            } else {
                this.nombre = nombre;
            }
            if (!esTelefonoValido(telefono)) {
                System.out.println(
                        "CUIDADO: El número de telefono aportado no es válido. Se ha establecido el valor por defecto.");
            } else {
                this.telefono = telefono;
            }
            if (!esEmailValido(email)) {
                System.out.println("CUIDADO: El email aportado no es valido. Se ha establecido el valor por defecto.");
            } else {
                this.email = email;
            }
        }
        this.dni = dni;
    }

    private static String transformarDniMayusculas(String dni) {
        if (dni == null || dni.isEmpty()) {
            return null;
        }
        return dni.toUpperCase();
    }

    private static String capitalizarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return nombre;
        }
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
    }

    private static boolean esDniValido(String dni) {
        if (dni == null || dni.isEmpty() || dni.length() != 9) {
            return false;
        } else {
            final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
            int numero = Integer.parseInt(dni.substring(0, 8));
            return (dni.matches("\\d{8}[A-Z]")) && ((dni.charAt(8)) == LETRAS.charAt(numero % 23));
        }
    }

    private static boolean esTelefonoValido(String telefono) {
        return (telefono.matches("[6-9]\\d{8}"));
    }

    private static boolean esEmailValido(String correo) {
        return correo.matches("[a-z0-9][a-z0-9.]*[a-z0-9]@[a-z0-9.]+[a-z0-9]\\.[a-z]{2,}");
    }

    @Override
    public String toString() {
        return "DNI: " + this.dni +
                ", Nombre: " + this.nombre +
                ", Tlf: " + this.telefono +
                ", Email: " + this.email;
    }

}
