package lab7.command;

import lab7.exception.RequiredParameterException;
import lab7.statistic.ElectroEnergyStatistic;

import java.util.List;

public class ShowHelpCommand extends Command {
    public ShowHelpCommand(String command, List<Argument> arguments, ElectroEnergyStatistic statistic) {
        super(command, arguments, statistic);
    }

    @Override
    public void execute() throws RequiredParameterException {
        System.out.println(
                        "Syntax: <command> -<parameter> <value>\n\n" +
                        "add         - Add new month statistic\n" +
                        "               Params:\n" +
                        "                   -m  - Month (please specify full name (case insensitive))\n" +
                        "                   -y  - Year\n" +
                        "                   -p  - Price of electricity for this month\n" +
                        "                   -s  - Value of electricity at the start of month\n" +
                        "                   -e  - Value of electricity at the end of month\n" +
                        "show         - Display all statistic\n" +
                        "test         - Fill with test data\n" +
                        "calculate    - Calculate the amount of electricity and amount to pay (without displaying)\n" +
                        "               Params:\n" +
                        "                   -a  - Calculate the whole statistic (All months objects)\n" +
                        "                   Or calculate by period:\n" +
                        "                   -y  - Start year\n" +
                        "                   -m  - Start month\n" +
                        "                   -Y  - End year\n" +
                        "                   -M  - End month\n" +
                        "               Examples:\n" +
                        "                   calculate -m APRIL -y 2019 -Y 2019 -M JANUARY   - calculates from April, 2019 till January, 2019\n" +
                        "                   calculate -a   - calculates all statistic\n" +
                        "exit         - Exit the terminal\n"

        );
    }
}
