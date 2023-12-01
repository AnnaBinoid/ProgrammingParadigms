package Sem02;
/**
 * Структурная(запрещен goto, три блока: утверждение, ветвление, цикл
 * легкость сопровождения, отладки, написания)
 * и Процедурная парадигмы (своя структура, логика, обертки процедурам)
 * это подмножество структурного программирования.
 */

public class Main02 {
    public static void main(String[] args) {
        /**
         * 01. Функция для вычисления факториала числа
         */
        /**
         * 01.1 Структурная парадигма
         */
        /*
        int result = 1;
        int n = 5;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println("5 factorial (structural) is: " + result);
        */
        /**
         * 01.2 Процедурная парадигма
         */
        /*
        Factorial factorial = new Factorial();
        System.out.println("5 factorial (procedure) is: " + factorial.nFactorial(5));
        System.out.println("5 factorial (procedure with rec) is: "
                + factorial.nFactorialRec(5));
        */
        /**
         * Структурная и процедурная парадигма сосредотачиваются на написании кода
         * и выполнении задач.
         * Императивная и декларативная парадигма сосредотачиваются на описании
         * конкретного результата и управлении состоянием.
         * Подходы могут перекрываться в зависимости от требований проекта и уровней
         * абстракции.
         */
        /**
         * 02. Калькулятор. Основная логика.
         */
        /*
        int num1 = 10;
        int num2 = 5;
        int result = 0;
         */
        /**
         * 02.1 Структурная парадигма
         */
        /**
         * 02.1.1 Сумма
         */
        /*
        result = num1 + num2;
        System.out.printf("The sum of numbers %d and %d is: %d.\n", num1, num2, result);
        */
        /**
         * 02.1.2 Разность
         */
        /*
        result = num1 - num2;
        System.out.printf("The difference of numbers %d and %d is: %d.\n", num1, num2, result);
        */
        /**
         * 02.1.3 Умножение
         */
        /*
        result = num1 * num2;
        System.out.printf("The product of numbers %d and %d is: %d.\n", num1, num2, result);
        */
        /**
         * 02.1.2 Деление
         */
        /*
        if (num2 != 0) {
            result = num1 / num2;
            System.out.printf("The quotient of numbers %d and %d is: %d.\n", num1, num2, result);
        }
        else System.out.println("You can't divide by 0!");
        */
        /**
         * 02.2 Процедурная
         */
        /*
        System.out.println(sum(num1, num2));
        System.out.println(diff(num1, num2));
        System.out.println(multi(num1, num2));
        System.out.println(div(num1, num2));
         */

    }

    /**
     * 02.2.1 Сумма
     * @param num1
     * @param num2
     * @return
     */
    public static int sum (int num1, int num2) {
        return num1 + num2;
    }
    /**
     * 02.2.2 Разность
     * @param num1
     * @param num2
     * @return
     */
    public static int diff (int num1, int num2){
        return num1 - num2;
    }
    /**
     * 02.2.3 Произведение
     * @param num1
     * @param num2
     * @return
     */
    public static int multi (int num1, int num2){
        return num1 * num2;
    }
    /**
     * 02.2.4 Частное
     * @param num1
     * @param num2
     * @return
     */
    public static int div (int num1, int num2) {
        if (num2 != 0) {
            return num1 / num2;
        }
        else {
            return -1;
        }
    }
}
