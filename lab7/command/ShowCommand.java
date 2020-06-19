package lab7.command;

import lab7.statistic.ElectroEnergyStatistic;
import lab7.statistic.MonthStatistic;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShowCommand extends Command {

    public ShowCommand(String command, List<Argument> arguments, ElectroEnergyStatistic statistic) {
        super(command, arguments, statistic);
    }

    @Override
    public void execute() {
        System.out.println("=================== ~STATISTIC~ ===================");
        ElectroEnergyStatistic t = (ElectroEnergyStatistic) target;
        t.getStatistics()
                .stream()
                .sorted(Comparator.comparing(m -> ((MonthStatistic) m).getYear()).thenComparing(m -> ((MonthStatistic) m).getMonth()))
                .forEach(this::printMonthStatisticItem);
        printTotalStatistic(t);
    }

    private void printTotalStatistic(ElectroEnergyStatistic t) {
        System.out.println("Total amount = " + t.getTotalAmount());
        System.out.println("Total amount to pay = " + t.getTotalAmountToPay());
        System.out.println("====================== ~END~ ======================");
    }

    private void printMonthStatisticItem(MonthStatistic m) {
        System.out.println(
                m.getMonth() +
                        ", " + m.getYear() +
                        ", end of previous month = " + m.getValueAtEndOfPreviousMonth() +
                        ", end of current month = " + m.getValueAtEndOfCurrentMonth() +
                        ", amount = " + m.getAmount() +
                        ", price = " + m.getPrice() +
                        ", amount to pay = " + m.getAmountToPay()
        );
    }
}
