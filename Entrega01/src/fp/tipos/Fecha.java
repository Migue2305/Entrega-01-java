package fp.tipos;
import java.util.Objects;

public class Fecha {
    private final Integer año;
    private final Integer mes;
    private final Integer dia;
    private static final String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                                                  "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private static final String[] nombresDiasSemana = {"Sábado", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
     
    public Integer getAño() {
        return año;
    }

    public Integer getMes() {
        return mes;
    }

    public Integer getDia() {
        return dia;
    }
    public Fecha(Integer año, Integer mes, Integer dia) {
        if (año < 1 || mes < 1 || mes > 12 || dia < 1 || dia > diasEnMes(año, mes)) {
            throw new IllegalArgumentException("Fecha no válida");
        }
        this.año = año;
        this.mes = mes;
        this.dia = dia;
        
    }

    public String nombreMes() {
        return nombresMeses[mes - 1];
    }

    public String diaSemana() {
        int valorZeller = calcularZeller(año, mes, dia);
        return nombresDiasSemana[valorZeller];
    }

    public Fecha sumarDias(int dias) {
        int diasTotales = diasDesdeInicio(año, mes, dia) + dias;
        return convertirDiasAFecha(diasTotales);
    }

    public Fecha restarDias(int dias) {
        int diasTotales = diasDesdeInicio(año, mes, dia) - dias;
        return convertirDiasAFecha(diasTotales);
    }

    public Integer diferenciaEnDias(Fecha fecha) {
        int dias1 = diasDesdeInicio(año, mes, dia);
        int dias2 = diasDesdeInicio(fecha.año, fecha.mes, fecha.dia);
        return Math.abs(dias1 - dias2);
    }

    private int diasDesdeInicio(int año, int mes, int dia) {
        int dias = 0;
        for (int i = 1; i < año; i++) {
            dias += esAñoBisiesto(i) ? 366 : 365;
        }
        for (int i = 1; i < mes; i++) {
            dias += diasEnMes(año, i);
        }
        dias += dia;
        return dias;
    }

    private static int calcularZeller(int año, int mes, int dia) {
        if (mes == 1 || mes == 2) {
            mes += 12;
            año--;
        }
        int k = año % 100;
        int j = año / 100;
        int h = (dia + 26 * (mes + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;
        return (h + 6) % 7; // Ajuste para que el domingo sea el primer día de la semana
    }

    private static int diasEnMes(int año, int mes) {
        if (mes == 2) {
            return esAñoBisiesto(año) ? 29 : 28;
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    private static boolean esAñoBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
    }

    private static Fecha convertirDiasAFecha(int dias) {
        int año = 1;
        while (dias > (esAñoBisiesto(año) ? 366 : 365)) {
            dias -= esAñoBisiesto(año) ? 366 : 365;
            año++;
        }
        int mes = 1;
        while (dias > diasEnMes(año, mes)) {
            dias -= diasEnMes(año, mes);
            mes++;
        }
        return new Fecha(año, mes, dias);
        }
        public String toString() {
            return diaSemana() + ", " + dia + " de " + nombreMes() + " de " + año;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Fecha fecha = (Fecha) obj;
            return año.equals(fecha.año) && mes.equals(fecha.mes) && dia.equals(fecha.dia);
        }

        @Override
        public int hashCode() {
            return Objects.hash(año, mes, dia);
        }

        public int compareTo(Fecha otraFecha) {
            if (this.año.equals(otraFecha.año)) {
                if (this.mes.equals(otraFecha.mes)) {
                    return this.dia.compareTo(otraFecha.dia);
                } else {
                    return this.mes.compareTo(otraFecha.mes);
                }
            } else {
                return this.año.compareTo(otraFecha.año);
            }
        }
     // Método de factoría 'of' para construir un objeto fecha a partir del año, mes y día indicados
        public static Fecha of(Integer año, Integer mes, Integer dia) {
            return new Fecha(año, mes, dia);
        }
        
        // Método de factoría 'parse' para construir un objeto fecha a partir de una cadena de caracteres
        // con la información del año, mes y día en formato "yyyy-MM-dd"
        public static Fecha parse(String cadenaFecha) {
            String[] partes = cadenaFecha.split("-");
            if (partes.length != 3) {
                throw new IllegalArgumentException("Formato de fecha incorrecto. Debe ser 'yyyy-MM-dd'.");
            }
            try {
                Integer año = Integer.parseInt(partes[0]);
                Integer mes = Integer.parseInt(partes[1]);
                Integer dia = Integer.parseInt(partes[2]);
                return new Fecha(año, mes, dia);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Formato de fecha incorrecto. Debe ser 'yyyy-MM-dd'.");}
            }
         // Método para determinar si un año es bisiesto
            public static boolean esAñoBisiesto(Integer año) {
                return (año % 4 == 0 && año % 100 != 0) || (año % 400 == 0);
            }
            
            // Método para obtener el número de días en un mes de un año determinado
            public static Integer díasEnMes(Integer año, Integer mes) {
                if (mes == 2) {
                    return esAñoBisiesto(año) ? 29 : 28;
                } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    return 30;
                } else {
                    return 31;
                }
            }
            
            // Método para calcular la congruencia de Zeller y obtener el día de la semana
            public static String congruenciaZeller(Integer año, Integer mes, Integer dia) {
                if (mes < 3) {
                    mes += 12;
                    año--;
                }
                int k = año % 100;
                int j = año / 100;
                int h = (dia + 13 * (mes + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
                
                // Día de la semana según el resultado de la congruencia de Zeller
                String[] diasSemana = {"Sábado", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
                return diasSemana[h];
            
        }
}
        


 