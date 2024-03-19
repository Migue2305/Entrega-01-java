package fp.funciones;

import java.util.ArrayList;
import java.util.List;

public class test_funciones {
    // Función para comprobar si un número es primo
    public static void comprobarPrimo(int numero) {
        if (numero <= 1) {
            System.out.println("El número " + numero + " no es primo.");
            return;
        }

        boolean esPrimo = true;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                esPrimo = false;
                break;
            }
        }

        if (esPrimo) {
            System.out.println("El número " + numero + " es primo.");
        } else {
            System.out.println("El número " + numero + " no es primo.");
        }
    }

    // Función para calcular el factorial de un número
    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // Función para calcular el coeficiente binomial (n choose k)
    public static long calcularCombinatorio(int n, int k) {
        if (n < k) {
            throw new IllegalArgumentException("n debe ser mayor o igual que k");
        }
        long numerador = factorial(n);
        long denominador = factorial(k) * factorial(n - k);
        return numerador / denominador;
    }

    // Función para calcular el valor de S
    public static double calcularS(int n, int k) {
        double resultado = 0.0;
        for (int i = 0; i <= k; i++) {
            resultado += Math.pow(-1, i) * calcularCombinatorio(k, i) * Math.pow((k - i), n);
        }
        return resultado / factorial(k);
    }

    // Función para obtener diferencias entre números en una lista
    public static List<Integer> obtenerDiferencias(List<Integer> numeros) {
        List<Integer> diferencias = new ArrayList<>();
        if (numeros.isEmpty()) {
            return diferencias;
        }
        int previo = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            int actual = numeros.get(i);
            int diferencia = actual - previo;
            diferencias.add(diferencia);
            previo = actual;
        }
        return diferencias;
    }

    // Función para encontrar la cadena más larga en una lista de cadenas
    public static String cadenaMasLarga(List<String> cadenas) {
        if (cadenas.isEmpty()) {
            return null;
        }
        String masLarga = cadenas.get(0);
        for (String cadena : cadenas) {
            if (cadena.length() > masLarga.length()) {
                masLarga = cadena;
            }
        }
        return masLarga;
    }

    // Método principal para probar las funciones
    public static void main(String[] args) {
        // Ejemplo de uso de las funciones
        comprobarPrimo(7); // Comprobar si 7 es primo
        System.out.println("Resultado de calcularCombinatorio(5, 2): " + calcularCombinatorio(5, 2)); // Calcular 5 choose 2
        System.out.println("Resultado de calcularS(5, 2): " + calcularS(5, 2)); // Calcular el valor de S para n=5 y k=2

        // Ejemplo de obtener diferencias entre números en una lista
        List<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(9);
        numeros.add(12);
        numeros.add(20);
        System.out.println("Diferencias entre números en la lista: " + obtenerDiferencias(numeros)); 

        // Ejemplo de encontrar la cadena más larga en una lista de cadenas
        List<String> cadenas = new ArrayList<>();
        cadenas.add("Hola");
        cadenas.add("Esta es la cadena mas larga");
        cadenas.add("Una cadena larga");
        cadenas.add("Cadena");
        System.out.println("Cadena más larga: " + cadenaMasLarga(cadenas));
    }
}