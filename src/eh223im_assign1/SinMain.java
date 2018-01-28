package eh223im_assign1;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SinMain {
    public static void main(String[] args) {
        // Create and Customize Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(2);

        // Generate data
        List xData = new ArrayList();
        List yData = new ArrayList();

        int resolution = 10000; // As many point as possible (warning: High CPU usage)

        for (int i = 0; i <= 2*Math.PI*resolution; i++) { // Repeat the process
            double k = (double) i;
            k /= resolution;
            xData.add(k);
            yData.add((1 + k/Math.PI)*Math.cos(k)*Math.cos(40*k));
        }

        // Display scatter plot
        chart.addSeries("Points", xData, yData);
        new SwingWrapper(chart).displayChart();
    }
}
