package fp.tipos;

public class TestFecha {
    public static void main(String[] args) {
        Fecha fecha = new Fecha(2024, 3, 13);
        System.out.println("Año: " + fecha.getAño());
        System.out.println("Mes: " + fecha.getMes());
        System.out.println("Día: " + fecha.getDia());
        System.out.println("Fecha: " + fecha);
        System.out.println("Nombre del mes: " + fecha.nombreMes());
        System.out.println("Día de la semana: " + fecha.diaSemana());
        System.out.println("Sumar 10 días: " + fecha.sumarDias(10));
        System.out.println("Restar 5 días: " + fecha.restarDias(5));
        Fecha fecha2 = new Fecha(2024, 3, 20);
        System.out.println("Diferencia en días: " + fecha.diferenciaEnDias(fecha2));

        // Crear algunas fechas
        Fecha fecha1 = new Fecha(2023, 10, 6);
        Fecha fecha5 = new Fecha(2023, 10, 7);
        Fecha fecha3 = new Fecha(2023, 9, 30);

        // Comparar las fechas
        int comparacion1 = fecha1.compareTo(fecha5);
        int comparacion2 = fecha1.compareTo(fecha3);

        // Imprimir los resultados
        System.out.println("Comparación entre fecha1 y fecha5: " + comparacion1);
        System.out.println("Comparación entre fecha1 y fecha3: " + comparacion2);

        // Comprobar si las fechas son iguales
        boolean iguales = fecha1.equals(fecha5);
        System.out.println("¿Las fechas son iguales?: " + iguales);
        
        Fecha fecha6 = Fecha.of(2023, 9, 20);
        System.out.println("Fecha 6 (of): " + fecha6);

        Fecha fecha7 = Fecha.parse("2023-09-20");
        System.out.println("Fecha 7 (parse): " + fecha7);
         // Verificar si un año es bisiesto
        boolean esBisiesto = Fecha.esAñoBisiesto(2023);
        System.out.println("¿El año 2024 es bisiesto?: " + esBisiesto);

        // Obtener el número de días en el mes de marzo de 2023
        int díasMarzo2023 = Fecha.díasEnMes(2024, 2 );
        System.out.println("Número de días en marzo de 2023: " + díasMarzo2023);

        // Obtener el día de la semana para la fecha 13 de marzo de 2024
        String diaSemana = Fecha.congruenciaZeller(2024, 3, 19);
        System.out.println("Día de la semana para el 13 de marzo de 2024: " + diaSemana);
    }

}
