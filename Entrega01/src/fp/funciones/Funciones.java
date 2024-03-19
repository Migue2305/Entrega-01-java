package fp.funciones;
import java.util.ArrayList;
import java.util.List;

public class Funciones {

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

        if (esPrimo) {
            System.out.println("El número " + numero + " es primo.");
        } else {
            System.out.println("El número " + numero + " no es primo.");
        }
    }
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

    public static long calcularCombinatorio(int n, int k) {
        if (n < k) {
        	throw new IllegalArgumentException("n debe ser mayor o igual que k");
        }
        long numerador = factorial(n);
        long denominador = factorial(k) * factorial(n - k);
        return numerador / denominador;
        }
    public static double calcularS(int n, int k) {
        double resultado = 0.0;
        for (int i = 0; i <= k; i++) {
            resultado += Math.pow(-1, i) * combinatorio(k, i) * Math.pow((k - i), n);
        }
        return resultado / factorial(k);
        }

    public static long combinatorio(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }
    public static List<Integer> obtenerDiferencias(List<Integer> numeros) {
        List<Integer> diferencias = new ArrayList<>();
        if (numeros.isEmpty()) {
            return diferencias; // Devuelve una lista vacía si la lista original está vacía
        }
        int previo = numeros.get(0); // Obtiene el primer elemento de la lista original
        for (int i = 1; i < numeros.size(); i++) {
            int actual = numeros.get(i); // Obtiene el elemento actual de la lista original
            int diferencia = actual - previo; // Calcula la diferencia entre el elemento actual y el anterior
            diferencias.add(diferencia); // Agrega la diferencia a la lista de diferencias
            previo = actual; // Actualiza el valor previo para el siguiente cálculo
        }
        return diferencias;
    } 
    public static String cadenaMasLarga(List<String> cadenas) {
        if (cadenas.isEmpty()) {
            return null; // Devuelve null si la lista está vacía
        }
        String masLarga = cadenas.get(0); // Inicializa la cadena más larga con el primer elemento de la lista
        for (String cadena : cadenas) {
            if (cadena.length() > masLarga.length()) {
                masLarga = cadena; // Actualiza la cadena más larga si se encuentra una cadena más larga
            }
        }
        return masLarga;
    }
}
    


    




       
