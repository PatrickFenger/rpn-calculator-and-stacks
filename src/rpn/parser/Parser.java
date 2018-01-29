package rpn.parser;

import rpn.parser.operations.*;
import utility.Stack;

import java.util.List;
import java.util.TreeSet;

public class Parser {
    public Stack<Integer> parseNumbers(Stack<Integer> numbers, String[] rawArguments) {
        for (String rawConsoleArgument : rawArguments) {
            try {
                Integer number = Integer.parseInt(rawConsoleArgument);
                numbers.push(number);
            } catch (NumberFormatException e) {
                break;
            }
        }
        return numbers;
    }

    public List<Operation> parseOperations(List<Operation> operations, int countOfAddedNumbers, String[] rawConsoleArguments) throws ParserException {
        for (int i = countOfAddedNumbers; i < rawConsoleArguments.length; i++) {
            switch (rawConsoleArguments[i]) {
                case "*":
                    operations.add(new Multiplication());
                    break;
                case "/":
                    operations.add(new Divison());
                    break;
                case "+":
                    operations.add(new Addition());
                    break;
                case "-":
                    operations.add(new Substitution());
                    break;
                default:
                    throw new ParserException("Unknown operation!");
            }
        }
        return operations;
    }


}
