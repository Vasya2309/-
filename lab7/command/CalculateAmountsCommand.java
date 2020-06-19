package lab7.command;

import lab7.exception.RequiredParameterException;
import lab7.statistic.ElectroEnergyStatistic;

import java.time.Month;
import java.util.List;

public class CalculateAmountsCommand extends Command {
    public CalculateAmountsCommand(String command, List<Argument> arguments, ElectroEnergyStatistic statistic) {
        super(command, arguments, statistic);
    }

    @Override
    public void execute() throws RequiredParameterException {
        ElectroEnergyStatistic t = (ElectroEnergyStatistic) target;
        if (containsValueByParameter("a")) {
            // calculate all months
            t.calculateTotalAmount();
            t.calculateTotalAmountToPay();
        } else {
            // calculate for period
            int startYear = Integer.parseInt(getValueByParameter("y"));
            Month startMonth = Month.valueOf(getValueByParameter("m").toUpperCase());
            int endYear = Integer.parseInt(getValueByParameter("Y"));
            Month endMonth = Month.valueOf(getValueByParameter("M").toUpperCase());
            t.calculateAmountsByPeriod(startYear, startMonth, endYear, endMonth);
        }
        System.out.println("~OK");
    }
}
