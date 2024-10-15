/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OchoReinas;

/**
 *
 * @author sofia
 */
public class OchoReinas {
    private static boolean esSeguro(int[] tablero, int fila, int col, int n) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i] == col || Math.abs(tablero[i] - col) == Math.abs(i - fila)) {
                return false; // Comparar las diagonales
            }
        }
        return true;
    }

    private static boolean resolver8Reinas(int[] tablero, int fila, int n) {
        if (fila == n) {    //
            return true;    //Caso base
        }                   //

        for (int col = 0; col < n; col++) {
            if (esSeguro(tablero, fila, col, n)) {
                tablero[fila] = col; 

                if (resolver8Reinas(tablero, fila + 1, n)) {
                    return true;
                }

                tablero[fila] = -1; 
            }
        }

        return false; 
    }
/*
    public static void resolverProblemaReinas(int n) {
        int[] tablero = new int[n]; 
        for (int i = 0; i < n; i++) {
            tablero[i] = -1; 
        }

        if (resolver8Reinas(tablero, 0, n)) {
            new TableroOchoReinas(tablero);//se crea metodo en la interfaz
        } else {
            System.out.println("No hay solución.");
        }
    }
    */
       public static void resolverProblemaReinas(int n) {
        int[] tablero = new int[n]; 
        for (int i = 0; i < n; i++) {
            tablero[i] = -1; 
        }

        if (OchoReinas.resolver8Reinas(tablero, 0, n)) {
            new TableroOchoReinas(tablero);
        } else {
            System.out.println("No hay solución.");
        }
    }

}

