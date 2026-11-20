package es.centro.veterinaria.modelo;

import java.time.LocalDate;
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

    public Animal(String nombre, String microchip, Especie especie, String raza, String fechaNac,
            Persona acompanhante) {
        contador++;
        this.id = contador;
        this.nombre = nombre;
        this.microchip = microchip;
        this.especie = especie;
        this.raza = raza;
        this.fechaNac = LocalDate.parse(fechaNac, Fechas.FORMATO_FECHA);
        this.acompanhante = acompanhante;
    }

    @Override
    public String toString() {
        return "{" + nombre +
                ", " + microchip +
                ", " + raza + ", " + especie +
                ", " + fechaNac.format(Fechas.FECHA) +
                ", " + acompanhante.getDni() + "}";
    }

}
