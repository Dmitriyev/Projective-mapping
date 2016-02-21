/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jogamp.opengl.awt.GLCanvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author nikita
 */
public class WindowGUI extends JFrame{

    public WindowGUI(GLCanvas glcanvas) {
        super("GridBagLayout");
        final JFrame frame = new JFrame ( );
        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
     //   frame.getContentPane().add( glcanvas );
        frame.setSize(sSize);
        frame.setVisible( true );
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new WindowPanel(glcanvas, sSize); 
        frame.add(panel);    
        
        System.out.println(frame.getSize());
    }
    
}
 