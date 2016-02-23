/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jogamp.opengl.awt.GLCanvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import figures.FIGURE;
import figures.ProjectiveTextureMapping;
import handlers.Renderer;

import java.awt.geom.Dimension2D;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import utils.FileChooser;
import utils.ParseConfig;

/**
 *
 * @author nikita
 */
public class FiguresUI extends javax.swing.JFrame {

    /**
     * Creates new form FiguresUI
     */
    public FiguresUI(GLCanvas glcanvas) {/*
        initComponents();
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.getContentPane().add(glcanvas);
        this.setVisible(true);*/

        initComponents();
        Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setExtendedState(MAXIMIZED_BOTH);
        glcanvas.setSize(sSize.width - 150, sSize.height);
        this.getContentPane().add(glcanvas);
        this.setVisible(true);
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cubeBtn = new javax.swing.JButton();
        selectFigureLabel = new javax.swing.JLabel();
        newSphereBtn = new javax.swing.JButton();
        pyramidBtn = new javax.swing.JButton();
        sphereParamsLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sphereParams = new javax.swing.JTextField();
        projectorFileBtn = new javax.swing.JButton();
        projectorFile = new javax.swing.JLabel();
        ProjectorSettings = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        configuration = new javax.swing.JRadioButton();
        byHands = new javax.swing.JRadioButton();
        projectorCoords = new javax.swing.JLabel();
        xCoordLabel = new javax.swing.JLabel();
        xCoord = new javax.swing.JFormattedTextField();
        yCoordLabel = new javax.swing.JLabel();
        zCoordLabel = new javax.swing.JLabel();
        yCoord = new javax.swing.JTextField();
        zCoord = new javax.swing.JTextField();
        anglesCoords = new javax.swing.JLabel();
        v1xLabel = new javax.swing.JLabel();
        v1yLabel = new javax.swing.JLabel();
        v1zLabel = new javax.swing.JLabel();
        v1xCoord = new javax.swing.JTextField();
        v1yCoord = new javax.swing.JTextField();
        v1zCoord = new javax.swing.JTextField();
        v2xLabel = new javax.swing.JLabel();
        v2yLabel = new javax.swing.JLabel();
        v2zLabel = new javax.swing.JLabel();
        v2xCoord = new javax.swing.JTextField();
        v2yCoord = new javax.swing.JTextField();
        v2zCoord = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 1000));

        cubeBtn.setText("Куб");
        cubeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cubeBtnActionPerformed(evt);
            }
        });

        selectFigureLabel.setText("Выберите фигуру");

        newSphereBtn.setText("Новая Сфера");
        newSphereBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSphereBtnActionPerformed(evt);
            }
        });

        pyramidBtn.setText("Пирамида");
        pyramidBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pyramidBtnActionPerformed(evt);
            }
        });

        sphereParamsLabel.setText("Число граней");

        sphereParams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sphereParamsActionPerformed(evt);
            }
        });

        projectorFileBtn.setText("Выбрать");
        projectorFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectorFileBtnActionPerformed(evt);
            }
        });

        projectorFile.setText("Файл для проектора:");

        ProjectorSettings.setText("Настройки проектора:");

        buttonGroup1.add(configuration);
        configuration.setText("Конфигурация");
        configuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configurationActionPerformed(evt);
            }
        });

        buttonGroup1.add(byHands);
        byHands.setSelected(true);
        byHands.setText("Задать вручную");
        byHands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byHandsActionPerformed(evt);
            }
        });

        projectorCoords.setText("Координаты проектора:");

        xCoordLabel.setText("x");

        yCoordLabel.setText("y");

        zCoordLabel.setText("z");

        yCoord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yCoordActionPerformed(evt);
            }
        });

        anglesCoords.setText("Координаты углов:");

        v1xLabel.setText("x1");

        v1yLabel.setText("y1");

        v1zLabel.setText("z1");

        v2xLabel.setText("x2");

        v2yLabel.setText("y2");

        v2zLabel.setText("z2");

        v2xCoord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v2xCoordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectorFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(configuration)
                            .addComponent(projectorCoords)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(zCoordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(anglesCoords)
                                    .addComponent(zCoord, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(yCoordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(xCoordLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(xCoord, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yCoord, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(v1xLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(v1xCoord, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(v1yLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(v1yCoord, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(v1zLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(v1zCoord, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(v2yLabel)
                                    .addComponent(v2zLabel)
                                    .addComponent(v2xLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(v2yCoord, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                    .addComponent(v2xCoord, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(v2zCoord)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(byHands, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ProjectorSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newSphereBtn)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(selectFigureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sphereParamsLabel)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(sphereParams, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel3))
                                        .addComponent(pyramidBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cubeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(projectorFileBtn)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(selectFigureLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cubeBtn)
                .addGap(1, 1, 1)
                .addComponent(pyramidBtn)
                .addGap(36, 36, 36)
                .addComponent(sphereParamsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sphereParams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newSphereBtn)
                .addGap(47, 47, 47)
                .addComponent(ProjectorSettings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(configuration)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(byHands)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectorCoords)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xCoordLabel)
                    .addComponent(xCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yCoordLabel)
                    .addComponent(yCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zCoordLabel)
                    .addComponent(zCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(anglesCoords)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(v1yLabel)
                            .addComponent(v1yCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(v2yLabel)
                            .addComponent(v2yCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(v1zLabel)
                            .addComponent(v2zLabel)
                            .addComponent(v2zCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(v1zCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(v2xLabel)
                        .addComponent(v1xCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(v2xCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(v1xLabel)))
                .addGap(18, 18, 18)
                .addComponent(projectorFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectorFileBtn)
                .addContainerGap(456, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 1153, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void byHandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byHandsActionPerformed
        setVisibleConfig(true);
    }//GEN-LAST:event_byHandsActionPerformed

    private void configurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configurationActionPerformed
        setVisibleConfig(false);
    }//GEN-LAST:event_configurationActionPerformed

    private void projectorFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectorFileBtnActionPerformed
        boolean isByHands = buttonGroup1.isSelected(byHands.getModel());
        ProjectiveTextureMapping ptm = new ProjectiveTextureMapping();
        FileChooser chooseFile = new FileChooser();
        if (isByHands) {
            try {
                ptm.setfvLightPos(Float.parseFloat(xCoord.getText()), Float.parseFloat(yCoord.getText()),
                                Float.parseFloat(zCoord.getText()), TOP_ALIGNMENT);
                ptm.setf3LightUp(Float.parseFloat(v1xCoord.getText()),Float.parseFloat(v1yCoord.getText()),
                                Float.parseFloat(v1zCoord.getText()));
                ptm.setf3LightDir(Float.parseFloat(v2xCoord.getText()), Float.parseFloat(v2xCoord.getText()), 
                        Float.parseFloat(v2xCoord.getText()));
                Renderer.projectorFile = chooseFile.selectFile();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Введите корректные координаты");
            }
        } else {
            try {
                ParseConfig parse = new ParseConfig(chooseFile.selectFile());
                ptm.setfvLightPos(parse.getCOORDS()[0],parse.getCOORDS()[1],parse.getCOORDS()[2],TOP_ALIGNMENT);
                ptm.setf3LightUp(parse.getVector1Coords()[0],parse.getVector1Coords()[1],parse.getVector1Coords()[2]);
                ptm.setf3LightDir(parse.getVector2Coords()[0],parse.getVector2Coords()[1],parse.getVector2Coords()[2]);
            } catch (IOException ex) {
                Logger.getLogger(FiguresUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_projectorFileBtnActionPerformed

    private void sphereParamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sphereParamsActionPerformed

    }//GEN-LAST:event_sphereParamsActionPerformed

    private void pyramidBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pyramidBtnActionPerformed
        Renderer.figure = FIGURE.PYRAMID;
    }//GEN-LAST:event_pyramidBtnActionPerformed

    private void newSphereBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSphereBtnActionPerformed
        String edges = sphereParams.getText();
        int numEdges;
        try {
            numEdges = Integer.parseInt(edges);
            if (numEdges < 40) {
                throw new Exception();
            }
            Renderer.lats = (int)Math.sqrt(numEdges);
            Renderer.longs = (int)Math.sqrt(numEdges);
            Renderer.figure = FIGURE.SPHERE;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Введите число граней больше 40");
        }
    }//GEN-LAST:event_newSphereBtnActionPerformed

    private void cubeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cubeBtnActionPerformed
        Renderer.figure = FIGURE.CUBE;
    }//GEN-LAST:event_cubeBtnActionPerformed

    private void v2xCoordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v2xCoordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_v2xCoordActionPerformed

    private void yCoordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yCoordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yCoordActionPerformed

    private void setVisibleConfig(boolean isVisible) {
        projectorCoords.setVisible(isVisible);
        xCoordLabel.setVisible(isVisible);
        yCoordLabel.setVisible(isVisible);
        zCoordLabel.setVisible(isVisible);
        xCoord.setVisible(isVisible);
        yCoord.setVisible(isVisible);
        zCoord.setVisible(isVisible);
        projectorFile.setVisible(isVisible);
        projectorCoords.setVisible(isVisible);
        v1xLabel.setVisible(isVisible);
        v1yLabel.setVisible(isVisible);
        v1zLabel.setVisible(isVisible);
        v2xLabel.setVisible(isVisible);
        v2yLabel.setVisible(isVisible);
        v2zLabel.setVisible(isVisible);
        v1xCoord.setVisible(isVisible);
        v1yCoord.setVisible(isVisible);
        v1zCoord.setVisible(isVisible);
        v2xCoord.setVisible(isVisible);
        v2yCoord.setVisible(isVisible);
        v2zCoord.setVisible(isVisible);
        anglesCoords.setVisible(isVisible);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ProjectorSettings;
    private javax.swing.JLabel anglesCoords;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton byHands;
    private javax.swing.JRadioButton configuration;
    private javax.swing.JButton cubeBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton newSphereBtn;
    private javax.swing.JLabel projectorCoords;
    private javax.swing.JLabel projectorFile;
    private javax.swing.JButton projectorFileBtn;
    private javax.swing.JButton pyramidBtn;
    private javax.swing.JLabel selectFigureLabel;
    private javax.swing.JTextField sphereParams;
    private javax.swing.JLabel sphereParamsLabel;
    private javax.swing.JTextField v1xCoord;
    private javax.swing.JLabel v1xLabel;
    private javax.swing.JTextField v1yCoord;
    private javax.swing.JLabel v1yLabel;
    private javax.swing.JTextField v1zCoord;
    private javax.swing.JLabel v1zLabel;
    private javax.swing.JTextField v2xCoord;
    private javax.swing.JLabel v2xLabel;
    private javax.swing.JTextField v2yCoord;
    private javax.swing.JLabel v2yLabel;
    private javax.swing.JTextField v2zCoord;
    private javax.swing.JLabel v2zLabel;
    private javax.swing.JFormattedTextField xCoord;
    private javax.swing.JLabel xCoordLabel;
    private javax.swing.JTextField yCoord;
    private javax.swing.JLabel yCoordLabel;
    private javax.swing.JTextField zCoord;
    private javax.swing.JLabel zCoordLabel;
    // End of variables declaration//GEN-END:variables
}
