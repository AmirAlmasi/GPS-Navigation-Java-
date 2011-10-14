/*
 * Map.java
 *  This class was implemented according to the material adopted from the given
 * website below:
 * @see http://wiki.openstreetmap.org/wiki/JXMapViewer
 * @see http://swinglabs.org/hudson/job/SwingX-WS%20Continuous%20Build/javadoc/org/jdesktop/swingx/JXMapViewer.html
 * @see http://today.java.net/pub/a/today/2007/11/13/mapping-mashups-with-jxmapviewer.html
 * As the API was suppoes to be used, some reseaches was done and finally this code
 * considering the studies material was prepared.
 * 
 * Created on Feb 5, 2011, 8:48:49 PM
 * Edited on Feb 10, 2011, 10:05:20 AM
 * Edited on May 2, 2011, 3:55:12 PM
 * Adding new test loc file to the software o check 
 * Edited on May 2, 2011, 5:25:30 PM
 * Adding new method to navigate amoung the locFile by calling dijkstra method
 * Edited on May 5, 2011, 12:03:15 PM
 * Changing the way to navigate to the waypoints in the loc file,
 * the way it was, navigating to all waypoints, is changed now to the way that,
 * navigate to a specefic waypoint in the loc file by asking user the number of
 * prefered waypoint.
 * Go to my current location is fixed.
 */
package GUI;

import Logic.Controler;
import Logic.SearchEngine.Manual.WaypointNode;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.JXMapViewer;
import org.jdesktop.swingx.mapviewer.GeoPosition;
import org.jdesktop.swingx.mapviewer.Waypoint;
import org.jdesktop.swingx.mapviewer.WaypointPainter;
import org.jdesktop.swingx.painter.Painter;

/**
 * A class to show OpenStreetMap on the JFrame and handle the graphical user interface.
 *
 * @author Amir Almasi
 * @see http://wiki.openstreetmap.org/wiki/JXMapViewer
 * @see http://swinglabs.org/hudson/job/SwingX-WS%20Continuous%20Build/javadoc/org/jdesktop/swingx/JXMapViewer.html
 * @see http://today.java.net/pub/a/today/2007/11/13/mapping-mashups-with-jxmapviewer.html
 * @version 0.6
 */
public class Map extends javax.swing.JFrame {

    // variable declarations
    private Controler controler;
    private boolean mouseDragFlag;
    private ArrayList<WaypointNode> list = new ArrayList<WaypointNode>();

    /**
     * Non-argument constructor.
     */
    public Map() {
        controler = new Controler();
        new Thread(controler).start();
        initComponents();
        jInternalFrame1.setOpaque(false);
        jInternalFrame1.getContentPane().setBackground(new Color(0, 0, 0, 0));
        setResizable(false);
    }

    /**
     * The method is called to set all the components on the JFrame.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        timeCheckBox = new javax.swing.JCheckBox();
        dateCheckBox = new javax.swing.JCheckBox();
        speedCheckBox = new javax.swing.JCheckBox();
        myLocationCheckBox = new javax.swing.JCheckBox();
        showLOCCheckBox = new javax.swing.JCheckBox();
        navigateLOCCheckBox = new javax.swing.JCheckBox();
        resetCheckBox = new javax.swing.JCheckBox();
        loadCheckBox = new javax.swing.JCheckBox();
        clearCheckBox = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        showLoc = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        resetSave = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        NavigateLoc = new javax.swing.JButton();
        currentLocation = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jXMapKit1 = new org.jdesktop.swingx.JXMapKit();
        jComboBox1 = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        save = new javax.swing.JMenuItem();
        load = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        setting = new javax.swing.JMenu();
        themeColor = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        aboutUs = new javax.swing.JMenuItem();
        version = new javax.swing.JMenuItem();
        helpHelp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        timeCheckBox.setSelected(true);
        timeCheckBox.setText("Time");
        timeCheckBox.setFocusable(false);
        timeCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        timeCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        timeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeCheckBoxActionPerformed(evt);
            }
        });
        jToolBar1.add(timeCheckBox);

        dateCheckBox.setSelected(true);
        dateCheckBox.setText("Date");
        dateCheckBox.setFocusable(false);
        dateCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dateCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        dateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateCheckBoxActionPerformed(evt);
            }
        });
        jToolBar1.add(dateCheckBox);

        speedCheckBox.setText("Speed");
        speedCheckBox.setEnabled(false);
        speedCheckBox.setFocusable(false);
        speedCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        speedCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(speedCheckBox);

        myLocationCheckBox.setSelected(true);
        myLocationCheckBox.setText("Go To My Location");
        myLocationCheckBox.setFocusable(false);
        myLocationCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myLocationCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        myLocationCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myLocationCheckBoxActionPerformed(evt);
            }
        });
        jToolBar1.add(myLocationCheckBox);

        showLOCCheckBox.setSelected(true);
        showLOCCheckBox.setText("Show LOC File");
        showLOCCheckBox.setFocusable(false);
        showLOCCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        showLOCCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        showLOCCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLOCCheckBoxActionPerformed(evt);
            }
        });
        jToolBar1.add(showLOCCheckBox);

        navigateLOCCheckBox.setSelected(true);
        navigateLOCCheckBox.setText("Navigation To Loc File");
        navigateLOCCheckBox.setFocusable(false);
        navigateLOCCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        navigateLOCCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        navigateLOCCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navigateLOCCheckBoxActionPerformed(evt);
            }
        });
        jToolBar1.add(navigateLOCCheckBox);

        resetCheckBox.setSelected(true);
        resetCheckBox.setText("Reset Save");
        resetCheckBox.setFocusable(false);
        resetCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        resetCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        resetCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetCheckBoxActionPerformed(evt);
            }
        });
        jToolBar1.add(resetCheckBox);

        loadCheckBox.setSelected(true);
        loadCheckBox.setText("Load");
        loadCheckBox.setFocusable(false);
        loadCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loadCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        loadCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadCheckBoxActionPerformed(evt);
            }
        });
        jToolBar1.add(loadCheckBox);

        clearCheckBox.setSelected(true);
        clearCheckBox.setText("Clear");
        clearCheckBox.setFocusable(false);
        clearCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clearCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clearCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearCheckBoxActionPerformed(evt);
            }
        });
        jToolBar1.add(clearCheckBox);
        jToolBar1.add(jLabel9);

        jLayeredPane1.setBackground(new java.awt.Color(204, 0, 0));
        jLayeredPane1.setForeground(new java.awt.Color(102, 102, 255));

        jInternalFrame1.setClosable(true);

        jLabel3.setText("<html>How to exit:<br>In order to exit, navigate to the file menu and select exit.<br><br>How to Save/Load locations:<br>Navigate to the file menu and click on either Save or Load.<br><br></html>");
        jTabbedPane1.addTab("Menu", jLabel3);

        jLabel4.setText("<html>In order to navigate to the shortest path, hover your mouse around the area you desire.<br>Once the pointer of the mouse changes to a 'glove', click that spot in order to see your path.<br>Immediately afterwards, a pop-up will be shown with the exact distance in meters. Press \"OK\" to close.<br>If the area is not reachable, a pop-up message will let the user know.<br></html>");
        jTabbedPane1.addTab("Shortest Path", jLabel4);

        jLabel5.setText("<html>In order to load the loc files, click on \"Show LOC\". The locations will appear on the map.<br>If the user wishes to navigate to these locations, he/she can simply click on \"Navigate to Loc\".<br> A menu will pop-up asking the user which location they would like to travel to.</html>");
        jTabbedPane1.addTab("LocFile Navigation", jLabel5);

        jLabel6.setText("<html>How to Save:<br>In order to save a location, navigate to File>Save. If you would like to clear a saved location, simply click on the 'Reset Save' button located on the default menu.<br>How to Load:<br>In order to load your saved files, you may either click on 'Load' from the default menu of the GPS, or go to 'File>Load'</html>");
        jTabbedPane1.addTab("Save & Load", jLabel6);

        jLabel7.setText("<html>In order for you to see where you currently are located on the map, simply click on 'Go To My Location' which is located under the map on the default menu. <br/>Feel free to navigate around the map and easily go back to your current location.</html>");
        jTabbedPane1.addTab("Current Position Return", jLabel7);

        jLabel8.setText("<html>How to customize the GPS?<br>You are able to change the color of the GPS to your preference simply by clicking on Setting>Theme Color<br> You will have many different colors to choose one, feel free to choose whichever you prefer.<br>Click on 'OK' after you have chosen.</html>");
        jTabbedPane1.addTab("Customizing", jLabel8);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );

        jInternalFrame1.setBounds(270, 60, 430, 340);
        jLayeredPane1.add(jInternalFrame1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        showLoc.setFont(new java.awt.Font("Tahoma", 1, 10));
        showLoc.setText("Show LOC File");
        showLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showLocActionPerformed(evt);
            }
        });
        showLoc.setBounds(190, 510, 110, 30);
        jLayeredPane1.add(showLoc, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setBackground(new java.awt.Color(255, 51, 51));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setBounds(350, 100, 200, 50);
        jLayeredPane1.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setText("jLabel10");
        jLabel10.setBounds(640, 30, -1, -1);
        jLayeredPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        resetSave.setFont(new java.awt.Font("Tahoma", 1, 10));
        resetSave.setText("Reset Save");
        resetSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetSaveActionPerformed(evt);
            }
        });
        resetSave.setBounds(460, 510, 90, 30);
        jLayeredPane1.add(resetSave, javax.swing.JLayeredPane.DEFAULT_LAYER);

        clearButton.setFont(new java.awt.Font("Tahoma", 1, 10));
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        clearButton.setBounds(660, 510, 70, 30);
        jLayeredPane1.add(clearButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        NavigateLoc.setFont(new java.awt.Font("Tahoma", 1, 10));
        NavigateLoc.setText("Navigate To LOC File");
        NavigateLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NavigateLocActionPerformed(evt);
            }
        });
        NavigateLoc.setBounds(310, 510, 130, 30);
        jLayeredPane1.add(NavigateLoc, javax.swing.JLayeredPane.DEFAULT_LAYER);

        currentLocation.setFont(new java.awt.Font("Tahoma", 1, 10));
        currentLocation.setText("Go To My Location");
        currentLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentLocationActionPerformed(evt);
            }
        });
        currentLocation.setBounds(50, 510, 130, 30);
        jLayeredPane1.add(currentLocation, javax.swing.JLayeredPane.POPUP_LAYER);

        loadButton.setFont(new java.awt.Font("Tahoma", 1, 10));
        loadButton.setText("Load");
        loadButton.setFocusable(false);
        loadButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loadButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        loadButton.setBounds(570, 510, 70, 30);
        jLayeredPane1.add(loadButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setText("Date: ");
        jLabel2.setBounds(10, 60, 170, 30);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Time: ");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setFocusCycleRoot(true);
        jLabel1.setFocusTraversalPolicyProvider(true);
        jLabel1.setBounds(10, 20, 150, 30);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jXMapKit1.setDefaultProvider(org.jdesktop.swingx.JXMapKit.DefaultProviders.OpenStreetMaps);
        jXMapKit1.setBounds(0, 0, 860, 550);
        jLayeredPane1.add(jXMapKit1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "On Foot", "By Bike", "By Car" }));
        jComboBox1.setBounds(420, 122, 140, 20);
        jLayeredPane1.add(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
        );

        file.setText("File");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        file.add(save);

        load.setText("Load");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });
        file.add(load);

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        file.add(exit);

        jMenuBar1.add(file);

        setting.setText("Setting");

        themeColor.setText("Theme Color");
        themeColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themeColorActionPerformed(evt);
            }
        });
        setting.add(themeColor);

        jMenuBar1.add(setting);

        help.setText("Help");

        aboutUs.setText("About Software");
        aboutUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutUsActionPerformed(evt);
            }
        });
        help.add(aboutUs);

        version.setText("Version");
        version.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                versionActionPerformed(evt);
            }
        });
        help.add(version);

        helpHelp.setText("Program Functionalities");
        helpHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpHelpActionPerformed(evt);
            }
        });
        help.add(helpHelp);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * A method to handle if user wants to see the current location.
     * @param evt
     */
    private void currentLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentLocationActionPerformed
        jXMapKit1.setAddressLocation(new GeoPosition(controler.getUserCurrentLocation().getLatitude(), controler.getUserCurrentLocation().getLongitude()));
    }//GEN-LAST:event_currentLocationActionPerformed

    /**
     * A method to handle if user wants to see the waypoints in the LOC file.
     * @param evt java.awt.event.ActionEvent.
     */
    private void showLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showLocActionPerformed
        addLocFile(controler.readLocFile());
        System.out.println("Reading loc file is Finished");
    }//GEN-LAST:event_showLocActionPerformed

    /**
     * A method to navigate to waypoints located in the loc file.
     * @param evt java.awt.event.ActionEvent.
     */
    private void NavigateLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NavigateLocActionPerformed
        if (list.size() < 2) {
            list.addAll(controler.locNavigation(jComboBox1.getSelectedIndex(), Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Input number of the loc file"))));
        } else {
            list.removeAll(list);
            setPainter();
            list.addAll(controler.locNavigation(jComboBox1.getSelectedIndex(), Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Input number of the loc file"))));
        }
//                    if (addWaypoint(controler.implementsDijkstra(controler.getUserCurrentLocation().getLatitude(), controler.getUserCurrentLocation().getLongitude(), jXMapKit1.getMainMap().convertPointToGeoPosition(evt.getPoint()).getLatitude(), jXMapKit1.getMainMap().convertPointToGeoPosition(evt.getPoint()).getLongitude(), jComboBox1.getSelectedIndex()))) {
        addWaypoint(list);
    }//GEN-LAST:event_NavigateLocActionPerformed

    /**
     * A method to change the theme of the software.
     * @param evt java.awt.event.ActionEvent.
     */
    private void themeColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themeColorActionPerformed
        // TODO add your handling code here:
        Color c = new JColorChooser().showDialog(rootPane, null, Color.yellow);
        currentLocation.setBackground(c);
        showLoc.setBackground(c);
        NavigateLoc.setBackground(c);
        loadButton.setBackground(c);
        clearButton.setBackground(c);
        resetSave.setBackground(c);
        jToolBar1.setBackground(c);
        jMenuBar1.setBackground(c);
        jComboBox1.setBackground(c);
        timeCheckBox.setBackground(c);
        dateCheckBox.setBackground(c);
        speedCheckBox.setBackground(c);
        myLocationCheckBox.setBackground(c);
        showLOCCheckBox.setBackground(c);
        navigateLOCCheckBox.setBackground(c);
        resetCheckBox.setBackground(c);
        loadCheckBox.setBackground(c);
        clearCheckBox.setBackground(c);
        this.setBackground(c);
}//GEN-LAST:event_themeColorActionPerformed
    private void timeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeCheckBoxActionPerformed
        if (timeCheckBox.isSelected()) {
            jLabel1.setVisible(true);
        } else {
            jLabel1.setVisible(false);
        }
    }//GEN-LAST:event_timeCheckBoxActionPerformed

    /**
     * A method to appear and disappear the data button on the screen.
     * @param evt java.awt.event.ActionEvent.
     */
    private void dateCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateCheckBoxActionPerformed
        if (dateCheckBox.isSelected()) {
            jLabel2.setVisible(true);
        } else {
            jLabel2.setVisible(false);
        }
    }//GEN-LAST:event_dateCheckBoxActionPerformed

    /**
     * A method to exit the software.
     * @param evt java.awt.event.ActionEvent.
     */
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(-1);
    }//GEN-LAST:event_exitActionPerformed

    /**
     * A method to show the information about the software.
     * @param evt java.awt.event.ActionEvent.
     */
    private void aboutUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutUsActionPerformed
        new MyInfo(Color.red);
    }//GEN-LAST:event_aboutUsActionPerformed

    /**
     * A method to show the help system for the user.
     * @param evt java.awt.event.ActionEvent.
     */
    private void helpHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpHelpActionPerformed
        jInternalFrame1.setVisible(true);
    }//GEN-LAST:event_helpHelpActionPerformed

    /**
     * A method to appear and disappear go to my location button on the screen.
     * @param evt java.awt.event.ActionEvent.
     */
    private void myLocationCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myLocationCheckBoxActionPerformed
        if (myLocationCheckBox.isSelected()) {
            currentLocation.setVisible(true);
        } else {
            currentLocation.setVisible(false);
        }
    }//GEN-LAST:event_myLocationCheckBoxActionPerformed

    /**
     * A method to appear and disappear the show loc file button on the screen.
     * @param evt java.awt.event.ActionEvent.
     */
    private void showLOCCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showLOCCheckBoxActionPerformed
        if (showLOCCheckBox.isSelected()) {
            showLoc.setVisible(true);
        } else {
            showLoc.setVisible(false);
        }
    }//GEN-LAST:event_showLOCCheckBoxActionPerformed

    /**
     * A method to appear and disappear the navigate to loc waypoints button on the screen.
     * @param evt java.awt.event.ActionEvent.
     */
    private void navigateLOCCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navigateLOCCheckBoxActionPerformed
        if (navigateLOCCheckBox.isSelected()) {
            NavigateLoc.setVisible(true);
        } else {
            NavigateLoc.setVisible(false);
        }
    }//GEN-LAST:event_navigateLOCCheckBoxActionPerformed

    /**
     * A method to appear and disappear the reset button on the screen.
     * @param evt java.awt.event.ActionEvent.
     */
    private void resetCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetCheckBoxActionPerformed
        if (resetCheckBox.isSelected()) {
            resetSave.setVisible(true);
        } else {
            resetSave.setVisible(false);
        }
    }//GEN-LAST:event_resetCheckBoxActionPerformed

    /**
     * A method to load the waypoints from text file.
     * @param evt java.awt.event.ActionEvent.
     */
    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        loadFromFile();
    }//GEN-LAST:event_loadButtonActionPerformed

    /**
     * A method to load the waypoints from text file.
     * @param evt java.awt.event.ActionEvent.
     */
    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
        loadFromFile();
    }//GEN-LAST:event_loadActionPerformed

    /**
     * A method to appear and disappear the load button on the screen.
     * @param evt java.awt.event.ActionEvent.
     */
    private void loadCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadCheckBoxActionPerformed
        if (loadCheckBox.isSelected()) {
            loadButton.setVisible(true);
        } else {
            loadButton.setVisible(false);
        }
    }//GEN-LAST:event_loadCheckBoxActionPerformed

    /**
     * A method to show the information about the version of the system.
     * @param evt java.awt.event.ActionEvent.
     */
    private void versionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_versionActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Version 0.1");
    }//GEN-LAST:event_versionActionPerformed

    /**
     * A method to clear the screen from the shown waypoints.
     * @param evt java.awt.event.ActionEvent.
     */
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        resetShoertestPath();

    }//GEN-LAST:event_clearButtonActionPerformed

    /**
     * A method to save the passed waypoints in a text file.
     * @param evt java.awt.event.ActionEvent.
     */
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        if (controler.saveToFile()) {
            JOptionPane.showMessageDialog(rootPane, " Save to file is done!!");
        }
    }//GEN-LAST:event_saveActionPerformed

    /**
     * A method to reset the waypoints which are going to be saved in a text file.
     * @param evt java.awt.event.ActionEvent.
     */
    private void resetSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetSaveActionPerformed
        // TODO add your handling code here:
        controler.resetSave();
    }//GEN-LAST:event_resetSaveActionPerformed

    /**
     * A method to appear and disappear the clear button on the screen.
     * @param evt java.awt.event.ActionEvent.
     */
    private void clearCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearCheckBoxActionPerformed
        // TODO add your handling code here:
        if (clearCheckBox.isSelected()) {
            clearButton.setVisible(true);
        } else {
            clearButton.setVisible(false);
        }

    }//GEN-LAST:event_clearCheckBoxActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NavigateLoc;
    private javax.swing.JMenuItem aboutUs;
    private javax.swing.JButton clearButton;
    private javax.swing.JCheckBox clearCheckBox;
    private javax.swing.JButton currentLocation;
    private javax.swing.JCheckBox dateCheckBox;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu file;
    private javax.swing.JMenu help;
    private javax.swing.JMenuItem helpHelp;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private org.jdesktop.swingx.JXMapKit jXMapKit1;
    private javax.swing.JMenuItem load;
    private javax.swing.JButton loadButton;
    private javax.swing.JCheckBox loadCheckBox;
    private javax.swing.JCheckBox myLocationCheckBox;
    private javax.swing.JCheckBox navigateLOCCheckBox;
    private javax.swing.JCheckBox resetCheckBox;
    private javax.swing.JButton resetSave;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenu setting;
    private javax.swing.JCheckBox showLOCCheckBox;
    private javax.swing.JButton showLoc;
    private javax.swing.JCheckBox speedCheckBox;
    private javax.swing.JMenuItem themeColor;
    private javax.swing.JCheckBox timeCheckBox;
    private javax.swing.JMenuItem version;
    // End of variables declaration//GEN-END:variables

    /**
     * a method to run this class in thread and set the map in advanced.
     */
    public void showMap() {
//        addWaypoint();
        jXMapKit1.setZoom(2);
        /**
         * a method to put some text on the screen top, left(provided by NASA)
         */
        Painter<JXMapViewer> textOverlay = new Painter<JXMapViewer>() {

            public void paint(Graphics2D g, JXMapViewer map, int w, int h) {
                g.setPaint(new Color(0, 0, 0, 150));
                g.fillRoundRect(50, 10, 182, 30, 10, 10);
                g.setPaint(Color.WHITE);
                g.drawString("Images provided by NASA", 50 + 10, 10 + 20);
            }
        };
        jXMapKit1.setAddressLocation(new GeoPosition(57.7069, 11.9369));
        jXMapKit1.getMainMap().addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                if (controler.checkMouseArea(jXMapKit1.getMainMap().convertPointToGeoPosition(e.getPoint()).getLatitude(), jXMapKit1.getMainMap().convertPointToGeoPosition(e.getPoint()).getLongitude(), 0)) {
                    jXMapKit1.getMainMap().setCursor(new Cursor(Cursor.HAND_CURSOR));
                    mouseDragFlag = true;
                } else {
                    jXMapKit1.getMainMap().setCursor(Cursor.getDefaultCursor());
                    mouseDragFlag = false;
                }
            }
        });
        jXMapKit1.getMainMap().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (mouseDragFlag) {
                    resetShoertestPath();
                    controler.setDestination(jXMapKit1.getMainMap().convertPointToGeoPosition(evt.getPoint()).getLatitude(), jXMapKit1.getMainMap().convertPointToGeoPosition(evt.getPoint()).getLongitude());
                    jXMapKit1.getMainMap().removeAll();
                    if (list.size() < 2) {
                        list.addAll(controler.implementsDijkstra(controler.getUserCurrentLocation().getLatitude(), controler.getUserCurrentLocation().getLongitude(), jXMapKit1.getMainMap().convertPointToGeoPosition(evt.getPoint()).getLatitude(), jXMapKit1.getMainMap().convertPointToGeoPosition(evt.getPoint()).getLongitude(), jComboBox1.getSelectedIndex()));
                    } else {
                        list.removeAll(list);
                        setPainter();
                        list.addAll(controler.implementsDijkstra(controler.getUserCurrentLocation().getLatitude(), controler.getUserCurrentLocation().getLongitude(), jXMapKit1.getMainMap().convertPointToGeoPosition(evt.getPoint()).getLatitude(), jXMapKit1.getMainMap().convertPointToGeoPosition(evt.getPoint()).getLongitude(), jComboBox1.getSelectedIndex()));
                    }
                    addWaypoint(list);
                    JOptionPane.showMessageDialog(null, String.format("%s %f Meters ", "Distance :", controler.getDistance(jXMapKit1.getMainMap().convertPointToGeoPosition(evt.getPoint()).getLatitude(), jXMapKit1.getMainMap().convertPointToGeoPosition(evt.getPoint()).getLongitude())));
                }
            }
        });
        getUserLocation();
    }

    /**
     * A method to add way points on the screen to be shown.
     */
    public void addWaypoint() {

        //create a Set of waypoints
        Set<Waypoint> waypoints = new HashSet<Waypoint>();
        waypoints.add(new Waypoint(57.7060999, 11.9372500));
        waypoints.add(new Waypoint(57.7068126, 11.9372572));
        WaypointPainter painter = new WaypointPainter();
        painter.setWaypoints(waypoints);
        jXMapKit1.getMainMap().setOverlayPainter(painter);
    }

    /**
     * A method to add way point on the screen
     * Over Load method.
     * @param list ArrayList<Logic.SearchEngine.Manual.WaypointNode
     * @return
     */
    public boolean addWaypoint(ArrayList<Logic.SearchEngine.Manual.WaypointNode> list) {

        //create a Set of waypoints
        Set<Waypoint> waypoints = new HashSet<Waypoint>();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                waypoints.add(new Waypoint(list.get(i).getLatitude(), list.get(i).getLongitude()));
            }
        } else {
            return false;
        }

        //crate a WaypointPainter to draw the points
        WaypointPainter painter = new WaypointPainter();
        painter.setWaypoints(waypoints);
        painter.setWaypoints(waypoints);
        jXMapKit1.getMainMap().setOverlayPainter(painter);
        return true;
    }

    /**
     * A method to add waypoints of LOC file on the screen.
     * @param list ArrayList<Logic.MyNode> list
     * @return
     */
    public void addLocFile(ArrayList<Logic.MyNode> list) {
        //create a Set of waypoints
        Set<Waypoint> waypoints = new HashSet<Waypoint>();
        if (list != null) {
            if (!(list.size() < 2)) {
                this.list.removeAll(this.list);
                setPainter();
            }
            for (int i = 0; i < list.size(); i++) {
                WaypointNode wn = new WaypointNode("");
                wn.setLatitude(list.get(i).getLatitude());
                wn.setLongitude(list.get(i).getLongitude());
                this.list.add(wn);
                addWaypoint(this.list);
                waypoints.add(new Waypoint(list.get(i).getLatitude(), list.get(i).getLongitude()));
            }
        }
    }

    /**
     *  A method to put text on the specific positions jXmapViewer.
     */
    private void infoOnScreen() {
        final JLabel hoverLabel = new JLabel("Java");
        hoverLabel.setVisible(false);
        jXMapKit1.getMainMap().add(hoverLabel);
        jXMapKit1.getMainMap().addMouseMotionListener(new MouseMotionListener() {

            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
                JXMapViewer map = jXMapKit1.getMainMap();
                //location of Java
                GeoPosition gp = new GeoPosition(57.7068126, 11.9372572);
                //convert to world bitmap
                Point2D gp_pt = map.getTileFactory().geoToPixel(gp, map.getZoom());
                //convert to screen
                Rectangle rect = map.getViewportBounds();
                Point converted_gp_pt = new Point((int) gp_pt.getX() - rect.x,
                        (int) gp_pt.getY() - rect.y);
                //check if near the mouse
                if (converted_gp_pt.distance(e.getPoint()) < 10) {
                    hoverLabel.setLocation(converted_gp_pt);
                    hoverLabel.setVisible(true);
                } else {
                    hoverLabel.setVisible(false);
                }
            }
        });
    }

    /**
     *  A method to get user current location from controller class and set
     * in a array list.
     * If the size of the array list is bigger than 1 then only first element 
     * which is user current location would be update.
     */
    private void setPainter() {
        WaypointNode wayPointNode = new WaypointNode("");
        wayPointNode.setLatitude(controler.getUserCurrentLocation().getLatitude());
        wayPointNode.setLongitude(controler.getUserCurrentLocation().getLongitude());
        if (list.size() < 1) {
            list.add(wayPointNode);
        } else {
            list.set(0, wayPointNode);
        }
    }

    /**
     * A method to load the waypoints from the text file.
     */
    private void loadFromFile() {
        ArrayList<WaypointNode> list = new ArrayList<WaypointNode>();
        list = controler.loadFromFile();
//        for (int i = 0; i < list.size(); i++) {
//            addWaypoint(list);
//        }
        addWaypoint(list);
        new MyChartJFrame(list);
    }

    /**
     * A method to clear all waypoints from the array list.
     */
    private void resetShoertestPath() {
        controler.resetShoertestPath();
        list.removeAll(list);
        setPainter();
    }

    /**
     * The main method of the class to get user current location from controller and show it
     * on screen continusly each o.200 sec.
     */
    private void getUserLocation() {
        while (true) {
            try {
                if (controler.getLocation()) {
                    if (!controler.checkDistance()) {
                        if (jLabel11.getText().equalsIgnoreCase("")) {
                            jLabel11.setText("  Wrong Way");
                        } else {
                            jLabel11.setText("");
                        }
                    } else {
                        jLabel11.setText("");
                    }
                    setPainter();
                    addWaypoint(list);
                    jLabel9.setText("Your current distance: " + (controler.getDistance(controler.getDestination().getLatitude(), controler.getDestination().getLongitude())).substring(0, 6));
                    jLabel10.setText(controler.getDistance() + "");
                }
                Thread.sleep(200);
            } catch (Exception e) {
//                System.out.println("Map class, getUserLocation(): there is problem and cought in catch");
            }
            // show time and date on the screen
            jLabel1.setText("Time: " + new GregorianCalendar().get(new GregorianCalendar().HOUR) + ":" + new GregorianCalendar().get(new GregorianCalendar().MINUTE) + ":" + new GregorianCalendar().get(new GregorianCalendar().SECOND));
            jLabel2.setText("Date: " + new GregorianCalendar().get(new GregorianCalendar().YEAR) + "," + (new GregorianCalendar().get(new GregorianCalendar().MONTH) + 1) + "," + new GregorianCalendar().get(new GregorianCalendar().DATE));
        }
    }
}
