/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IntfCaballo;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author chris
 */
public class CaballoTablero extends JPanel{
    private int[][] tablero;
    private final int tamCasilla = 60; // Tamaño de cada casilla en píxeles
    
    public CaballoTablero(int[][] tablero) {
        this.tablero = tablero;
        setPreferredSize(new Dimension(8 * tamCasilla, 8 * tamCasilla));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        // Definir colores para las casillas del tablero
    Color colorClaro = Color.LIGHT_GRAY;
    Color colorOscuro = Color.DARK_GRAY;
    Color colorVisitado = Color.RED;

    // Dibujar el tablero de ajedrez
    for (int i = 0; i < tablero.length; i++) {
        for (int j = 0; j < tablero[i].length; j++) {
            // Determinar el color de la casilla
            if (tablero[i][j] != -1) {
                g.setColor(colorVisitado); // Casillas visitadas resaltadas
            } else if ((i + j) % 2 == 0) {
                g.setColor(colorClaro); // Casillas claras
            } else {
                g.setColor(colorOscuro); // Casillas oscuras
            }
            
            // Dibujar la casilla
            g.fillRect(j * tamCasilla, i * tamCasilla, tamCasilla, tamCasilla);
        }
    }
}
    
    public void actualizarTablero(int[][] nuevoTablero) {
        this.tablero = nuevoTablero;
        repaint();
    }
}
