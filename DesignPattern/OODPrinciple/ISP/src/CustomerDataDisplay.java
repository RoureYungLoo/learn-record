/* 模块：客户数据显示接口 */
public interface CustomerDataDisplay {
    public void dataRead();

    public void transferToXML();

    public void createChart();

    public void displayChart();

    public void createReport();

    public void displayReport();

    /* 这个接口承担了太多职责，需要根据接口隔离原则和单一职责原则进行重构 */
}
