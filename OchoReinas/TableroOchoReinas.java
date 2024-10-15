/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OchoReinas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author chris
 */
public class TableroOchoReinas extends JFrame {
    private final int n;
    private final int[] tablero;
    private int filaActual = 0;
    private Timer timer;

    public TableroOchoReinas(int[] tablero) {
        this.n = tablero.length;
        this.tablero = tablero;

        setTitle("Solución del Problema de las Ocho Reinas");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PanelTablero panel = new PanelTablero();
        add(panel);

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (filaActual < n) {
                    panel.repaint();  // Re-pintar el tablero en cada paso
                    filaActual++;
                } else {
                    timer.stop(); // Detener el timer al terminar
                }
            }
        });

        setVisible(true);
        timer.start();
    }

    private class PanelTablero extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int cellSize = Math.min(getWidth(), getHeight()) / n;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if ((row + col) % 2 == 0) {
                        g.setColor(Color.LIGHT_GRAY);
                    } else {
                        g.setColor(Color.DARK_GRAY);
                    }
                    g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);

                    // Mostrar solo las reinas que ya fueron colocadas
                    if (row < filaActual && tablero[row] == col) {
                        g.setColor(Color.RED);
                        g.drawString("Q", col * cellSize + cellSize / 2 - 5, row * cellSize + cellSize / 2 + 5);
                    }
                }
            }
        }
    }
     }