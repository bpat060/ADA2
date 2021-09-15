/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.ada;

/**
 *
 * @author ynb9219
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel implements ActionListener {

    private DrawPanel drawPanel;

    public GUI() {
        super(new BorderLayout());

        JPanel southPanel = new JPanel();
        add(southPanel, BorderLayout.SOUTH);
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == "") {

        }

    }

    private class DrawPanel extends JPanel {

        private Random random = new Random();

        public DrawPanel() {
            super();
            setPreferredSize(new Dimension(500, 500));
            setBackground(Color.WHITE);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tesselation Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GUI());
        frame.pack();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = frame.getSize();
        frame.setLocation((screenDimension.width - frameDimension.width) / 2, (screenDimension.height - frameDimension.height) / 2);
        frame.setVisible(true);
    }
}
