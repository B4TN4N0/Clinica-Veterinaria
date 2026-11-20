package es.centro.veterinaria.modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import es.centro.veterinaria.modelo.Fechas;

public class Animal {
    private static int contador = 0;
    private final int id;
    private String nombre;
    private String microchip;
    private Especie especie;
    private String raza;
    private LocalDate fechaNac;
    private Persona acompanhante;
    private double pesoActual;
    private double[] historialPeso = new double[6];

    public Animal(String nombre, String microchip, Especie especie, String raza, String fechaNac,
            Persona acompanhante) {
        contador++;
        if (esMicrochipValido(microchip)) {
            System.out.println("Animal registrado correctamente.");
        } else {
            System.out.println(
                    "CUIDADO: El microchip aportado no es válido. Se ha establecido el valor aportado, pero puede que algunas funciones del programa fallen.");
        }
        this.id = contador;
        this.nombre = nombre;
        this.microchip = microchip;
        this.especie = especie;
        this.raza = raza;
        this.fechaNac = LocalDate.parse(fechaNac, Fechas.FORMATO_FECHA);
        this.acompanhante = acompanhante;
    }

    public Animal(String nombre, Especie especie, String fechaNac, Persona acompanhante) {
        this(nombre, null, especie, null, fechaNac, acompanhante);
    }

    public String getEdad() {
        if (this.fechaNac == null) {
            return "Edad desconocida";
        }

        Period periodo = Period.between(this.fechaNac, LocalDate.now());
        int anhos = periodo.getYears();
        int meses = periodo.getMonths();

        if (anhos > 0) {
            return anhos + (anhos == 1 ? " año" : " años") + " y " + meses + (meses == 1 ? " mes" : " meses");
        }

        return meses + (meses == 1 ? " mes" : " meses");
    }

    public double[] getHistorialPeso() {
        return this.historialPeso;
    }

    private boolean esMicrochipValido(String microchip) {
        return microchip.matches("\\d{15}");
    }

    public void registrarPeso(double peso) {
        this.pesoActual = peso;
        if (historialPeso[historialPeso.length - 1] == 0.0) {
            for (int i = 0; i < historialPeso.length; i++) {
                if (historialPeso[i] == 0.0) {
                    historialPeso[i] = peso;
                    break;
                }
            }
            return;
        }

        for (int i = 0; i < historialPeso.length - 1; i++) {
            historialPeso[i] = historialPeso[i + 1];
        }
        historialPeso[historialPeso.length - 1] = peso;
    }

    public String variacionPeso() {
        double variacionPeso = (historialPeso[5] - historialPeso[0]) / (historialPeso[0]) * 100;
        return variacionPeso + "%";
    }

    @Override
    public String toString() {
        return "{" + nombre +
                ", " + pesoActual +
                ", " + microchip +
                ", " + raza + ", " + especie +
                ", " + fechaNac.format(Fechas.FECHA) +
                ", " + acompanhante.getDni() + "}";
    }

}
