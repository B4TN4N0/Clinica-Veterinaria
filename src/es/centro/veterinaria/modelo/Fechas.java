package es.centro.veterinaria.modelo;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Fechas {
    protected static Locale IDIOMA_FECHA = Locale.forLanguageTag("es-ES");
    protected static DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected static DateTimeFormatter FECHA = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", IDIOMA_FECHA);
    protected static DateTimeFormatter DIA_CITA = DateTimeFormatter.ofPattern("EEEE d MMMM", IDIOMA_FECHA);
}
