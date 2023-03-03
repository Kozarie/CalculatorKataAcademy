import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner get = new Scanner(System.in);
        System.out.println("Введите математическое выражение с 2-мя арабскими или римскими числами через пробел");
        String expression = get.nextLine();
        String[] input = expression.split(" ");

        //Оператор


        //Проверка на соответствие
        if (input.length > 3 || input.length < 3) {
            throw new Exception("Должно быть 2 операнда и 1 оператор");
        }
        //Первый операнд
        String num1 = input[0];

        int tempForNum1 = 0;
        int roman1 = 1;
        boolean isRoman1 = false;
        boolean isArabian1 = false;

        //Проверка на римское первого числа
        for (int i = 1; i < Romas.romanArray.length; i++) {
            if (num1.equals(Romas.romanArray[i])) {
                roman1 = i;
                isRoman1 = true;
                isArabian1 = false;
            }
        }
        if (isRoman1 == true && roman1 < 1 || isRoman1 == true && roman1 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        //Если не римское, то арабское
        try {
            if (isRoman1 == false && Integer.parseInt(num1) == Integer.parseInt(num1)) {
                tempForNum1 = Integer.parseInt(num1);
                isArabian1 = true;
                isRoman1 = false;
                if (tempForNum1 > 10 || tempForNum1 <= 0) {
                    throw new Exception("Числа должны быть от 1 до 10");
                }
            }
        } catch (NumberFormatException e) {
            throw new Exception("Неподдерживаемая математическая операция");
        }

        //Второй операнд
        String num2 = input[2];

        int tempForNum2 = 0;
        int roman2 = 1;
        boolean isRoman2 = false;
        boolean isArabian2 = false;

        //Проверка на римское второго числа
        for (int i = 1; i < Romas.romanArray.length; i++) {
            if (num2.equals(Romas.romanArray[i])) {
                roman2 = i;
                isRoman2 = true;
                isArabian2 = false;
            }
        }
        if (isRoman2 == true && roman2 < 1 || isRoman2 == true && roman2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        //Если не римское, то арабское
        try {
            if (isRoman2 == false && Integer.parseInt(num2) == Integer.parseInt(num2)) {
                tempForNum2 = Integer.parseInt(num2);
                isArabian2 = true;
                isRoman2 = false;
                if (tempForNum2 > 10 || tempForNum2 <= 0) {
                    throw new Exception("Числа должны быть от 1 до 10");
                }
            }
        } catch (NumberFormatException e) {
            throw new Exception("Неподдерживаемая математическая операция");
        }

        //Проверка на формат чисел (римское/римское),(арабское/арабское);
        if (isRoman1 == true && isArabian1 == false && isArabian2 == true && isRoman2 == false || isArabian1 == true && isRoman1 == false && isArabian2 == false && isRoman2 == true) {
            throw new Exception("Используются разные системы счисления");
        }
        //Оператор
        String operation = input[1];
        //Результат операций с римскими числами
        String resultRoman = "";
        String resultArabian = "";
        //Считаем римские числа
        if (isRoman1 == true && isRoman2 == true) {
            int res = 0;if (operation.equals("+")) {
                res = roman1 + roman2;
            } else if (operation.equals("-")) {
                res = roman1 - roman2;
            } else if (operation.equals("*")) {
                res = roman1 * roman2;
            } else if (operation.equals("/")) {
                res = roman1 / roman2;
            } else {
                throw new Exception("Неверный оператор");
            }
            if (res < 1) {
                throw new Exception("В римской системе счисления отсутствует 0 и отрицательные числа");
            }
            for (int i = 0; i <= res; i++) {
                resultRoman = Romas.romanArray[i];
            }
            System.out.println(resultRoman);
            //Считаем арабские числа
        } else if (isArabian1 == true && isArabian2 == true) {
            if (operation.equals("+")) {
                resultArabian = String.valueOf(tempForNum1 + tempForNum2);
            } else if (operation.equals("-")) {
                resultArabian = String.valueOf(tempForNum1 - tempForNum2);
            } else if (operation.equals("*")) {
                resultArabian = String.valueOf(tempForNum1 * tempForNum2);
            } else if (operation.equals("/")) {
                resultArabian = String.valueOf(tempForNum1 / tempForNum2);
            } else {
                throw new Exception("Неверный оператор");
            }
            System.out.println(resultArabian);
        }
    }
}

class Romas {
    static String[] romanArray = new String[]{"O0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};
}