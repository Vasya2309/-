package lab7.command;

import lab7.exception.RequiredParameterException;
import lab7.statistic.ElectroEnergyStatistic;
import lab7.statistic.MonthStatistic;

import java.time.Month;
import java.util.List;

/**
 * AddCommand: add new Month statistic to the target
 * Required params: m (Month), y (Year)
 * None required: p (Price), s (Start value), e (End value)
 **/
public class AddCommand extends Command {

    public AddCommand(String command, List<Argument> arguments, ElectroEnergyStatistic target) {
        super(command, arguments, target);
    }

    public AddCommand(String command) {
        super(command);
    }

    public AddCommand() {
    }

    @Override
    public void execute() throws RequiredParameterException {
        ElectroEnergyStatistic t = (ElectroEnergyStatistic) target;
        String month = getValueByParameter("m");
        String year = getValueByParameter("y");
        long startValue = 0;
        long endValue = 0;
        double price = 0;
        try {
            startValue = Long.parseLong(getValueByParameter("s"));
        } catch (RequiredParameterException e) {
            // This params is not required, so it does not make sense
        }
        try {
            endValue = Long.parseLong(getValueByParameter("e"));
        } catch (RequiredParameterException e) {
            // This params is not required, so it does not make sense
        }
        try {
            price = Double.parseDouble(getValueByParameter("p"));
        } catch (RequiredParameterException e) {
            // This params is not required, so it does not make sense
        }

        MonthStatistic m = new MonthStatistic(Month.valueOf(month.toUpperCase()), Integer.parseInt(year));
        m.setPrice(price);
        m.setValueAtEndOfPreviousMonth(startValue);
        m.setValueAtEndOfCurrentMonth(endValue);
        t.add(m);
        System.out.println("~OK");
    }
}
