package eh223im_assign1;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.CategorySeries;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.print("Please enter the input file path: ");
        String inputFile = scan.nextLine();
        File file = new File(inputFile);
        Scanner inFile = new Scanner(file);
//        PrintWriter outFile = new PrintWriter();
        Scanner inConsole = new Scanner(System.in);
        int[] res = new int[10]; // In order from pos 0 to pos 10: 1-10, 11-20, ... 91 - 100
        int countInRange = 0;
        int countOutRange = 0;

        while (inFile.hasNext()) {
            int check;
            try {
                check = Integer.parseInt(inFile.nextLine());
            } catch (NumberFormatException e) {
                check = 0;
                countOutRange--;
            }

            if (check % 10 == 0) {
                switch (check / 10) {
                    case 1:
                        countInRange++;
                        res[0]++;
                        break;
                    case 2:
                        countInRange++;
                        res[1]++;
                        break;
                    case 3:
                        countInRange++;
                        res[2]++;
                        break;
                    case 4:
                        countInRange++;
                        res[3]++;
                        break;
                    case 5:
                        countInRange++;
                        res[4]++;
                        break;
                    case 6:
                        countInRange++;
                        res[5]++;
                        break;
                    case 7:
                        countInRange++;
                        res[6]++;
                        break;
                    case 8:
                        countInRange++;
                        res[7]++;
                        break;
                    case 9:
                        countInRange++;
                        res[8]++;
                        break;
                    case 10:
                        countInRange++;
                        res[9]++;
                        break;
                    default:
                        countOutRange++;
                        break;
                }
            } else {
                switch (check / 10) {
                    case 0:
                        countInRange++;
                        res[0]++;
                        break;
                    case 1:
                        countInRange++;
                        res[1]++;
                        break;
                    case 2:
                        countInRange++;
                        res[2]++;
                        break;
                    case 3:
                        countInRange++;
                        res[3]++;
                        break;
                    case 4:
                        countInRange++;
                        res[4]++;
                        break;
                    case 5:
                        countInRange++;
                        res[5]++;
                        break;
                    case 6:
                        countInRange++;
                        res[6]++;
                        break;
                    case 7:
                        countInRange++;
                        res[7]++;
                        break;
                    case 8:
                        countInRange++;
                        res[8]++;
                        break;
                    case 9:
                        countInRange++;
                        res[9]++;
                        break;
                    default:
                        countOutRange++;
                        break;
                }
            }
        }

        System.out.println("Number of integers in the interval [1,100]: " + countInRange);
        System.out.println("Other: " + countOutRange);

        for (int i = 0; i < 10; i++) {
            int count = 0;
            String outString = (i * 10 + 1) + " - " + ((i + 1) * 10) + "  " + "\t" + "|" + "\t";
            System.out.print(outString);
            for (int j = 0; j < res[i]; j++) {
                System.out.print("*");
                count++;
            }
            System.out.println();
        }

        // OLD PROGRAM

        // Create and Customize Chart
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).build();
        chart.getStyler().setDefaultSeriesRenderStyle(CategorySeries.CategorySeriesRenderStyle.Bar);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);

        // Generate data
        List xData = new ArrayList();
        List yData = new ArrayList();

        for (int i = 0; i < 10; i++) {
            xData.add(Integer.toString(i * 10 + 1) + " - " + Integer.toString((i + 1) * 10));
            yData.add(res[i]);
        }

//        xData.add("Other");
//        yData.add(countOutRange);

        // Display scatter plot
        chart.addSeries("Result",xData,yData);
        new SwingWrapper(chart).displayChart();



        inFile.close();
//        outFile.close();
        inConsole.close();
    }
}

/*
 * Adopted parts from: https://memorynotfound.com/detect-os-name-version-java/
 * Reason? If Windows, I will write file on C:\{path}
 * else if on Mac: ~/{path}
 * else if other: /{path} or ~/{path}
 */