/*
 * MyInfo.java
 *
 * Created on May 3, 2011, 6:27:51 PM
 */
package GUI;

import java.awt.Color;

/**
 * The class contains some information about the project showing in a transparent JFrame.
 * @author Amir Almasi
 * @version 0.2
 */
public class MyInfo extends javax.swing.JFrame {

    /**
     * Constructor.
     * @param c color
     */
    public MyInfo(Color c) {
        TransparentBackground bg = new TransparentBackground(this, c);
        getContentPane().add(bg);
        pack();
        setSize(750, 400);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    /**
     * A method to set components on the JFrame.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
