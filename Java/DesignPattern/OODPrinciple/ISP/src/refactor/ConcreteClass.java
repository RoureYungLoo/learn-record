package refactor;

public class ConcreteClass implements DataHandler,ChartHandler{
    @Override
    public void createChart() {
        System.out.println("创建图表");
    }

    @Override
    public void displayChart() {
        System.out.println("展示图表");
    }

    @Override
    public void dataRead() {
        System.out.println("读取数据");
    }
}
