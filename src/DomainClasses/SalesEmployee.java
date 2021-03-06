package DomainClasses;

public class SalesEmployee extends Employee {

    private int id;
    private float commission_rate;
    private double total_sales;

    //constructors
    public void SalesEmployee(){
    }

    public float getCommission_rate() {
        return commission_rate;
    }

    public void setCommission_rate(float commission_rate) throws IllegalArgumentException {

        if(commission_rate < 0){
            throw new IllegalArgumentException("Please enter a Commission Rate greater than 0");
        } else this.commission_rate = commission_rate;
    }

    public double getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(double total_sales) throws IllegalArgumentException {

        if(total_sales < 0){
            throw new IllegalArgumentException("Please enter a Total Sales greater than 0");
        } else this.total_sales = total_sales;
    }

    @Override
    public double calcGrossPay(){
        return super.calcGrossPay() + (getCommission_rate()*getTotal_sales());

    }

}
