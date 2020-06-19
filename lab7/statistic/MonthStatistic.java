package lab7.statistic;

import java.time.Month;

public class MonthStatistic {
    private Month month;
    private int year;

    private long valueAtEndOfPreviousMonth;
    private long valueAtEndOfCurrentMonth;
    private long amount;

    private double price;
    private double amountToPay;

    public MonthStatistic(Month month, int year) {
        this.month = month;
        this.year = year;
    }

    public MonthStatistic(Month month, int year, long valueAtEndOfPreviousMonth, long valueAtEndOfCurrentMonth, double price) {
        this.month = month;
        this.year = year;
        this.valueAtEndOfPreviousMonth = valueAtEndOfPreviousMonth;
        this.valueAtEndOfCurrentMonth = valueAtEndOfCurrentMonth;
        this.price = price;
    }

    public void setValueAtEndOfPreviousMonth(long valueAtEndOfPreviousMonth) {
        this.valueAtEndOfPreviousMonth = valueAtEndOfPreviousMonth;
        calculateAmount();
        calculateAmountToPay();
    }

    public void setValueAtEndOfCurrentMonth(long valueAtEndOfCurrentMonth) {
        this.valueAtEndOfCurrentMonth = valueAtEndOfCurrentMonth;
        calculateAmount();
        calculateAmountToPay();
    }

    public void calculateAmount() {
        amount = valueAtEndOfCurrentMonth - valueAtEndOfPreviousMonth;
    }

    public void calculateAmountToPay() {
        amountToPay = amount * price;
    }

    public Month getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public long getValueAtEndOfPreviousMonth() {
        return valueAtEndOfPreviousMonth;
    }

    public long getValueAtEndOfCurrentMonth() {
        return valueAtEndOfCurrentMonth;
    }

    public long getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }
}
