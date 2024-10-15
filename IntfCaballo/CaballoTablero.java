/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IntfCaballo;
import RecorridoCaballo.Caballo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        super.paintComponent(g);
        
        // Dibujar el tablero de ajedrez
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.LIGHT_GRAY);
                } else {
                    g.setColor(Color.DARK_GRAY);
                }
                g.fillRect(j * tamCasilla, i * tamCasilla, tamCasilla, tamCasilla);
                
                // Dibujar el número del movimiento en la casilla
                if (tablero[i][j] != -1) {
                    g.setColor(Color.RED);
                    g.drawString(String.valueOf(tablero[i][j]), 
                                 j * tamCasilla + tamCasilla / 2 - 5, 
                                 i * tamCasilla + tamCasilla / 2 + 5);
                }
            }
        }
    }
    
    public void actualizarTablero(int[][] nuevoTablero) {
        this.tablero = nuevoTablero;
        repaint();
    }
}