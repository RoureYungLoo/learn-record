public class ConcreteClass implements CustomerDataDisplay {
    @Override
    public void dataRead() {
        System.out.println("读取数据");
    }

    @Override
    public void transferToXML() {
        System.out.println("数据写入XML");
    }

    @Override
    public void createChart() {
        System.out.println("创建图表");
    }

    @Override
    public void displayChart() {
        System.out.println("展示图表");
    }

    @Override
    public void createReport() {
        System.out.println("创建报表");
    }

    @Override
    public void displayReport() {
        System.out.println("展示报表");
    }
}
