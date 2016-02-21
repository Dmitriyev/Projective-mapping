/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jogamp.opengl.awt.GLCanvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author nikita
 */
public class WindowPanel extends JPanel {

    public WindowPanel(GLCanvas glcanvas, Dimension ssize) {
        JButton b1 = new JButton("1");// создание кнопки с надписью 1

        JButton b2 = new JButton("2"); //создание кнопки с надписью 2

        JButton b3 = new JButton("3");//создание кнопки с  надписью 3
        glcanvas.setSize(ssize.width-300,ssize.height);
      /*  add (glcanvas);
        add(b1);//добавление на панель

        add(b2);

        add(b3);*/
      add(b1, new GridBagConstraints(0, 0, 1, 2, 0, 0, GridBagConstraints.NORTH,
            GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
      add(glcanvas,new GridBagConstraints(2, 0, 2, 1, 1, 0,
            GridBagConstraints.SOUTH, GridBagConstraints.BOTH, new Insets(5, 0, 5, 5), 0, 0));
    }
}
