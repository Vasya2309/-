package lab7.command;

import lab7.exception.RequiredParameterException;
import lab7.statistic.ElectroEnergyStatistic;
import lab7.statistic.MonthStatistic;

import java.time.Month;
import java.util.List;

public class FillWithTestDataCommand extends Command {
    public FillWithTestDataCommand(String command, List<Argument> arguments, ElectroEnergyStatistic statistic) {
        super(command, arguments, statistic);
    }

    @Override
    public void execute() throws RequiredParameterException {
        ElectroEnergyStatistic t = (ElectroEnergyStatistic) target;

        t.add(new MonthStatistic(Month.FEBRUARY, 2019, 13, 115, 10.1));
        t.add(new MonthStatistic(Month.MARCH, 2019, 115, 244, 10.1));
        t.add(new MonthStatistic(Month.APRIL, 2019, 244, 400, 10.2));
        t.add(new MonthStatistic(Month.SEPTEMBER, 2019, 400, 645, 10.5));
        t.add(new MonthStatistic(Month.MAY, 2020, 645, 986, 10.8));
        t.add(new MonthStatistic(Month.APRIL, 2018, 0, 13, 8.0));
        t.add(new MonthStatistic(Month.SEPTEMBER, 2020, 1500, 1600, 11.0));
        System.out.println("~OK");
    }
}
