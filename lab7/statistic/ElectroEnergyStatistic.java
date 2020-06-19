package lab7.statistic;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ElectroEnergyStatistic {
    private List<MonthStatistic> statistics;
    private long totalAmount;
    private long totalAmountToPay;

    public ElectroEnergyStatistic() {
        statistics = new ArrayList<>();
    }

    public void calculateTotalAmount() {
        validate();
        totalAmount = 0;
        statistics.forEach(monthStatistic -> totalAmount += monthStatistic.getAmount());
    }

    public void calculateTotalAmountToPay() {
        validate();
        totalAmountToPay = 0;
        statistics.forEach(monthStatistic -> totalAmountToPay += monthStatistic.getAmountToPay());
    }

    public void calculateAmountsByPeriod(int startYear, Month startMonth, int endYear, Month endMonth) {
        validate();
        totalAmount = 0;
        totalAmountToPay = 0;
        for (MonthStatistic s : statistics) {
            LocalDate monthDate = LocalDate.of(s.getYear(), s.getMonth().getValue(), 1);
            LocalDate startDate = LocalDate.of(startYear, startMonth.getValue(), 1);
            LocalDate endDate = LocalDate.of(endYear, endMonth.getValue(), 1);
            if ((monthDate.isAfter(startDate) || monthDate.equals(startDate))
                    && (monthDate.isBefore(endDate) || monthDate.equals(endDate))) {
                totalAmount += s.getAmount();
                totalAmountToPay += s.getAmountToPay();
            }
        }
    }

    public void validate() {
        for (MonthStatistic s : statistics) {
            s.calculateAmount();
            s.calculateAmountToPay();
        }
    }

    public boolean add(MonthStatistic m) {
        return statistics.add(m);
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public long getTotalAmountToPay() {
        return totalAmountToPay;
    }

    public List<MonthStatistic> getStatistics() {
        return statistics;
    }
}
