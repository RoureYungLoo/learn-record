package refactor.chart;

import refactor.chart.AbstractChart;

public class ChartDisplay2 {
    private AbstractChart chart;

    public void setChart(AbstractChart chart) {
        this.chart = chart;
    }

    public void display() {
        this.chart.display();
    }
}
