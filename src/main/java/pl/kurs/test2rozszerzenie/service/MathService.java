package pl.kurs.test2rozszerzenie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;
import pl.kurs.test2rozszerzenie.exception.InvalidEquationFormatException;
import pl.kurs.test2rozszerzenie.exception.UnknownOperatorException;
import pl.kurs.test2rozszerzenie.repository.OperationHistory;
import pl.kurs.test2rozszerzenie.repository.OperationHistoryRepository;


import java.time.LocalDate;
import java.util.*;

@Service
public class MathService {

    @Autowired
    private OperationHistoryRepository operationHistoryRepository;



    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("calculator");
        String input = scanner.nextLine();
        double result = (MathService.evaluate(input));
        System.out.println(result);
        saveToDataBase(input, result);
    }



    public static double evaluate(String expression) {
        checkExpressionIsCorrect(expression);

        char[] digitAndOperatorList = expression.toCharArray();
        Stack<Double> values = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < digitAndOperatorList.length; i++) {
            if (digitAndOperatorList[i] == ' ') continue;
            if (digitAndOperatorList[i] >= '0' && digitAndOperatorList[i] <= '9') {
                StringBuilder stringBuilder = new StringBuilder();
                while (i < digitAndOperatorList.length && digitAndOperatorList[i] >= '0' && digitAndOperatorList[i] <= '9')
                    stringBuilder.append(digitAndOperatorList[i++]);
                values.push(Double.parseDouble(stringBuilder.toString()));
                i--;
            } else if (digitAndOperatorList[i] == '(')
                operator.push(digitAndOperatorList[i]);
            else if (digitAndOperatorList[i] == ')') {
                while (operator.peek() != '(')
                    pushValues(values, operator);
                operator.pop();
            }    else if (digitAndOperatorList[i] == OperationImpl.SUBTRACT.symbol && (i == 0 || !Character.isDigit(digitAndOperatorList[i - 1]))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(digitAndOperatorList[i++]);
                    while (i < digitAndOperatorList.length && digitAndOperatorList[i] >= '0' && digitAndOperatorList[i] <= '9')
                        stringBuilder.append(digitAndOperatorList[i++]);
                    values.push(Double.parseDouble(stringBuilder.toString()));
                    i--;
            } else if (OperationImpl.isOperator(digitAndOperatorList[i])) {
                while (!operator.empty() && orderOfOperations(digitAndOperatorList[i],
                                operator.peek())) {
                    pushValues(values, operator);
                }
                operator.push(digitAndOperatorList[i]);
            }
        }
        while (!operator.empty())
            pushValues(values, operator);
            return values.pop();

    }

    private void saveToDataBase(String input, double result) {
        OperationHistory operationHistory = new OperationHistory();
        operationHistory.setExpression(input);
        operationHistory.setResult(result);
        operationHistory.setLocalDate(LocalDate.now());
        operationHistoryRepository.save(operationHistory);
    }

    private static void pushValues(Stack<Double> values, Stack<Character> operator) {
        values.push(applyOperation(operator.pop(),
                values.pop(),
                values.pop()));
    }

    private static void checkExpressionIsCorrect(String expression) {
        if (expression == null || expression.chars().allMatch(Character::isWhitespace)) {
            throw new InvalidEquationFormatException("Expression can't be null or empty");
        }
        if (!expression.matches("^[0-9+\\-*/()]+$")) {
            throw new UnknownOperatorException("Equation must include only +, -, *, /");
        }
        if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == OperationImpl.SUBTRACT.symbol) {
            return;
        } throw new InvalidEquationFormatException("Equation must start with a number");
    }


    public static boolean orderOfOperations ( char op1, char op2){
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == OperationImpl.MULTIPLY.symbol || op1 == OperationImpl.DIVIDE.symbol) &&
                (op2 == OperationImpl.ADD.symbol || op2 == OperationImpl.SUBTRACT.symbol))
            return false;
        else
            return true;
    }

    public static double applyOperation ( char op, double b, double a) throws UnknownOperatorException {
        if (a == 0 && op == OperationImpl.DIVIDE.symbol || b == 0 && op == OperationImpl.DIVIDE.symbol) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return OperationImpl.getOperator(op).operation(b, a);
    }



}


