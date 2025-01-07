public class Client {
    private CustomerDataDisplay customerDataDisplay;

    public CustomerDataDisplay getCustomerDataDisplay() {
        return customerDataDisplay;
    }

    public void setCustomerDataDisplay(CustomerDataDisplay customerDataDisplay) {
        this.customerDataDisplay = customerDataDisplay;
    }

    public void displayChart() {
        customerDataDisplay.displayChart();
    }
}
