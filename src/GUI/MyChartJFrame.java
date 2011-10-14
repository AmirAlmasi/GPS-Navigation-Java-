/*
 * MyChartJFrame.java
 *
 * Created on Mar 18, 2011, 11:31:31 AM
 */
package GUI;

import Logic.SearchEngine.Manual.WaypointNode;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * A class to show the final chart of passed ways on the screen.
 * @author Amir Almasi
 * @version 0.2
 */
public class MyChartJFrame extends javax.swing.JFrame {

    // Variables declaration 
    private MyChartPanel myChartPanel;

    /**
     * The constructor
     * @param list The ArrayList which keeps all objects of the Information
     */
    public MyChartJFrame(ArrayList<WaypointNode> list1) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myChartPanel = new MyChartPanel();

        // setting the values in the chart
        for (WaypointNode info : list1) {
            myChartPanel.setValue(((info.getLatitude() + "") + (info.getLongitude() + "")), info.getLatitude() + info.getLongitude());
        }
        myChartPanel.setChar("Sort speed comparison ");
        jPanel1 = myChartPanel.Show();
        jPanel1.setLayout(null);
        createRootPane();
        frameInit();
        add(this.getContentPane().add(jPanel1));
        setSize(700, 700);
        setVisible(true);
    }
    // Variables declaration - do not modify

    /**
     * A method to set all components on the JFrame.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
