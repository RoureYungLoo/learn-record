public class Test {
    public static void main(String[] args) {
        Client client = new Client();
        ConcreteClass concreteClass = new ConcreteClass();
        client.setCustomerDataDisplay(concreteClass);
        client.displayChart();
    }
}
