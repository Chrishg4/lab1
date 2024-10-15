/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prgiilab;


import IntfCaballo.CaballoTablero;
import RecorridoCaballo.Caballo;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author chris
 */
public class PrgIILab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        int N = 8; // Tamaño del tablero
        int[][] tablero = new int[N][N];
        
        Caballo caballo = new Caballo(tablero);
        
        // Solicitar al usuario la posición inicial del caballo
        System.out.println("Introduce la posición inicial del caballo (fila y columna de 0 a 7):");
        System.out.print("Fila: ");
        int x = scanner.nextInt();
        System.out.print("Columna: ");
        int y = scanner.nextInt();

        // Configurar la posición inicial y realizar el recorrido
        caballo.setIniticial(x, y);
        
        if (caballo.recorridoCaballo(x, y, 1)) {
            System.out.println("Recorrido completado:");
            imprimirTablero(caballo.getTablero());
        } else {
            System.out.println("No se encontró una solución.");
        }
        
        scanner.close();
    }
    
    private static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.printf("%3d", tablero[i][j]);
            }
            System.out.println();
        }
    }
}
    
        /*
        int N = 8;
        int[][] tablero = new int[N][N];
        Caballo caballo = new Caballo(tablero);

        JFrame frame = new JFrame("Recorrido del Caballo");
        CaballoTablero panelTablero = new CaballoTablero(tablero);
        frame.add(panelTablero);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Solicitar posición inicial
        int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila inicial (0-7):"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna inicial (0-7):"));

        // Configurar el punto inicial y ejecutar el recorrido
        caballo.setIniticial(x, y);
        
        // Ejecutar el recorrido y actualizar el tablero
        if (caballo.recorridoCaballo(x, y, 1)) {
            panelTablero.actualizarTablero(caballo.getTablero());
            JOptionPane.showMessageDialog(frame, "Recorrido completado");
        } else {
            JOptionPane.showMessageDialog(frame, "No se encontró una solución.");
        }
        
    }

}
*/
