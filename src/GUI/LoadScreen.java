/*
 * LoadScreen.java
 * 
 * Created on Feb 9, 2011, 8:48:49 PM
 * Edited on May 2, 2011, 06:25:50 PM
 * The thread was equaled to zero for the test of the software to be run sooner
 * Edited on May 3, 2011, 12:25:30 PM
 * Adding Jpanel to the frame, Adding JLayerPane to the panel, Adding jLabel
 * to use a picture on the background, editting jProgressBar, changing color both
 */
package GUI;

import javax.swing.ImageIcon;

/**
 * A loading class to give the other classes more time to be loaded properly.
 * @author Amir Almasi
 * @version 0.3
 */
public class LoadScreen extends javax.swing.JFrame implements Runnable {

    // decleration of variables
    private final String imageAddress = "sources//Pictures//gps.jpg";

    /**
     * non-Argument constructor.
     */
    public LoadScreen() {
        setUndecorated(true);
    }

    /**
     * The run method to use this class in the Thread In addition the method
     * shows the loading page and when loading would be finished the page
     * would be dispose.
     */
    public void run() {
        setVisible(true);
        initComponents();
        repaint();
        ImageIcon icon = new ImageIcon(imageAddress);
        jLabel2.setIcon(icon);
        while (jProgressBar1.getValue() < 100) {
            // The if and else implementation to cheange the text in Jlabel
            if (jLabel1.getText().equalsIgnoreCase("Loading...")) {
                jLabel1.setText("Loading....");
            } else {
                if (jLabel1.getText().equalsIgnoreCase("Loading.")) {
                    jLabel1.setText("Loading..");
                } else {
                    if (jLabel1.getText().equalsIgnoreCase("Loading..")) {
                        jLabel1.setText("Loading...");
                    } else {
                        jLabel1.setText("Loading.");
                    }
                }
            }
            jProgressBar1.setValue(jProgressBar1.getValue() + 4);
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("LoadScreen class, run mehtod: there is a problem in the try and catch");
            }
        }
        dispose();
    }

    /**
     * A method to set the components on the screen.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Loading...");
        jLabel1.setBounds(310, 290, 200, 71);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jProgressBar1.setForeground(new java.awt.Color(255, 0, 0));
        jProgressBar1.setBounds(170, 440, 430, 24);
        jLayeredPane1.add(jProgressBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLabel2.setBounds(0, 0, 820, 530);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
