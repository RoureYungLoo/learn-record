

public class ChartDisplay {
    public void display(String type) {
        if (type.equals("pie")) {
            PieChart pieChart = new PieChart();
            pieChart.display();
        }
        if (type.equals("bar")) {
            BarChart barChart = new BarChart();
            barChart.display();
        }
        if (type.equals("line")) {
            LineChart lineChart = new LineChart();
            lineChart.display();
        }
        /* 每次新增图表类型，都要修改源代码，不符合开闭原则 */
    }
}
