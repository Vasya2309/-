package lab7;

import lab7.command.*;
import lab7.exception.CommandNotFoundException;
import lab7.exception.ExitFromPromptException;
import lab7.exception.RequiredParameterException;
import lab7.statistic.ElectroEnergyStatistic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static ElectroEnergyStatistic statistic = new ElectroEnergyStatistic();

    public static void main(String[] args) {
        while (askToPrompt()) {
        }
    }

    /**
     * Examples:
     * add -m october -y 2019
     * add -m october -y 2019 -p 10 -s 10212 -e 14455
     * set -m october -y 2019 -p 10 -s 10212 -e 14455
     * calc
     * calc --start-month october --start-year 2019 --end-month october --end-year 2020
     */
    private static boolean askToPrompt() {
        System.out.print("> ");
        String s = in.nextLine();
        try {
            Command command = parseCommand(s);
            command.execute();
        } catch (CommandNotFoundException e) {
            System.out.println("Command not found!");
        } catch (ExitFromPromptException e) {
            return false;
        } catch (RequiredParameterException e) {
            System.out.println("Parameter " + e.getParameterName() + " is required!");
        }
        return true;
    }

    private static Command parseCommand(String input) throws CommandNotFoundException, ExitFromPromptException {
        Pattern pattern = Pattern.compile("(\\w+)");
        Matcher matcher = pattern.matcher(input);
        String command = "";
        if (matcher.find()) {
            command = matcher.group(1);
        }
        if (command.length() == 0) {
            throw new CommandNotFoundException();
        }

        Pattern pattern1 = Pattern.compile("(-(\\w)) (\\w+)");
        Matcher matcher1 = pattern1.matcher(input);
        List<Argument> arguments = new ArrayList<>();
        while (matcher1.find()) {
            arguments.add(new Argument(matcher1.group(2), matcher1.group(3)));
        }

        if (command.equalsIgnoreCase("add")) {
            return new AddCommand(command, arguments, statistic);
        } else if (command.equalsIgnoreCase("show")) {
            return new ShowCommand(command, arguments, statistic);
        } else if (command.equalsIgnoreCase("exit")) {
            throw new ExitFromPromptException();
        } else if (command.equalsIgnoreCase("test")) {
            return new FillWithTestDataCommand(command, arguments, statistic);
        } else if (command.equalsIgnoreCase("help")) {
            return new ShowHelpCommand(command, arguments, statistic);
        } else if (command.equalsIgnoreCase("calculate")) {
            return new CalculateAmountsCommand(command, arguments, statistic);
        }
        throw new CommandNotFoundException();
    }
}
