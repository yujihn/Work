// Some diff
//Another diff

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calc {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\t\t\tЗапущено приложение калькулятор");
        System.out.println("При вводе десятичных используйте ',' в качестве разделителя");
        System.out.println("Диапазон допустимых значений составляет от 1.4E-45 до 3.4E+38");
        System.out.println("Допустимые операции: сложение(+), вычитание(-), умножение(*), \n\t\t\t\t\t деление(/), остаток от делениея(%)");
        double num1 = getDouble();
        char operation = getOperation();
        double num2 = getDouble();
        double result = calc(num1, num2, operation);
        DecimalFormat df = new DecimalFormat("0.###############"); // Изменение формата вывода
        String formattedNumber = df.format(result);
        System.out.println("Результат операции: " + formattedNumber);
    }

    // Ввод операндов
    public static double getDouble() {
        System.out.print("Введите число: ");
        double num;
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
            scanner.nextLine(); // Чистка буфера после чтения
        } else {
            System.out.print("Ошибку при вводе числа. Попробуйте еще раз. ");
            scanner.next(); // Считывание неверного ввода
            num = getDouble(); // Рекурсия в случае ошибки
        }
        return num; // Возврат значения
    }

    // Ввод мат. знака
    public static char getOperation() {
        System.out.print("Введите операцию: ");
        String input = scanner.nextLine().trim();

        if (input.length() == 1) { // Подсчет кол-ва символов
            char operation = input.charAt(0); // Проверка 1ого символа
            if (isValidOperation(operation)) {
                return operation; // Возврат значения
            } else {
                System.out.println("Введена недопустимая операция. Попробуйте еще раз.");
            }
        }
        return getOperation(); // Рекурсия в случае ошибки
    }


    // Проверка на допустимые операции (символы)
    private static boolean isValidOperation(char operation) {
        return operation == '+' || operation == '-' || operation == '*' || operation == '/' || operation == '%';
    }

    // Выполнение мат. операции
    public static double calc(double num1, double num2, char operation) {
        double result;
        switch (operation) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            case '%' -> result = num1 % num2;
            default -> result = calc(num1, num2, getOperation()); // Рекурсия в случае ошибки
        }
        return result; // Возврат на вывод
    }
}
