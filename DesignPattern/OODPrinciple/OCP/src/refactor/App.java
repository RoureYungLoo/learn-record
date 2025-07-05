package refactor;

import refactor.chart.ChartDisplay2;
import refactor.chart.PieChart;

public class App {
    public static void main(String[] args) {

        ChartDisplay2 chart = new ChartDisplay2();
        PieChart pieChart = new PieChart();
        chart.setChart(pieChart);
        chart.display();
    }
}
