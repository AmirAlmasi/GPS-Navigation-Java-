/*
 * MyChartPanel.java
 * 
 * Created on Mar 17, 2011, 1:20:30 PM
 */
package GUI;

import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 * A class to show the chart as a panel which will be added to the frame.
 * @author Amir Almasi
 * @version 0.2
 */
public class MyChartPanel extends JPanel {

    // Variables declaration
    private DefaultPieDataset dataset;
    private JFreeChart freeChart;

    /**
     * Non-argument constructor
     */
    public MyChartPanel() {
        setVisible(true);
        dataset = new DefaultPieDataset();
    }

    /**
     * A method to set the values in the chart
     * @param title of the object which would be the waypoint.
     * @param numDouble the value of how many times the waypoint was met.
     */
    public void setValue(String title, Double numDouble) {
        dataset.setValue(title, numDouble);
    }

    /**
     * A method to set the character.
     * @param title
     */
    public void setChar(String title) {
        freeChart = ChartFactory.createPieChart(title, dataset, true, true, false);

        PiePlot pp = (PiePlot) freeChart.getPlot();
        pp.setSectionOutlinesVisible(true);
        pp.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        pp.setNoDataMessage("There is not any data");
        pp.setCircular(true);
        pp.setLabelGap(0.01);
    }

    /**
     * A method to create a JPanel contains the chart.
     * @return JPanel
     */
    private JPanel createPanel() {
        return new ChartPanel(freeChart);
    }

    /**
     * A method to make the final panel
     * @return the final panel
     */
    public JPanel Show() {
        return createPanel();
    }
}
