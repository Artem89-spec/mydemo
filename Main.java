import java.util.Scanner;

class Main {
    public static String calc(String input) {
        String[] parts = input.split("");

        if (parts.length != 3) {
            throw new IllegalArgumentException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int value1;
        int value2;

        try {
            value1 = Integer.parseInt(parts[0]);
            value2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("throws Exception");
        }

        if (value1 < 1 || value1 > 10 || value2 < 1 || value1 > 10) {
            throw new IllegalArgumentException("throws Exception");
        }

        String operation = parts[1];
        int result;

        switch (operation) {
            case "+":
                result = value1 + value2;
                break;
            case "-":
                result = value1 - value2;
                break;
            case "*":
                result = value1 * value2;
                break;
            case "/":
                if (value2 == 0) {
                    throw new ArithmeticException("throws Exception");
                }
                result = value1 / value2;
                break;
            default:
                throw new IllegalArgumentException("throws Exception //т.к. строка не является математической операцией");
        }

        return Integer.toString(result);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input: ");
        while (true) {
            try {
                String input = scanner.nextLine();
                String result = calc(input);
                System.out.println("Output: " + result);
            } catch (Exception e) {
                System.out.println("throws Exception: " + e.getMessage());
                break;
            }
        }

    }

}
