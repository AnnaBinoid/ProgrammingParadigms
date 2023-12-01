package Sem01;

import java.util.Arrays;

public class Main01 {

    public static void main(String[] args) {
        /**
         * 01.1 Императивное: найти сумму всех четных чисел в списке (прописываем код сами)
         */
        /*
        int[] numbersI = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sumOfEvenI = 0;

        for (int i : numbersI) {
            if (i%2 == 0) {
                sumOfEvenI += i;
            }
        }

        System.out.println(sumOfEvenI);
        */
        /**
         * 01.2 Декларативное: Найти сумму всех четных чисел в списке (использован встроенный метод)
         */
        /*
        int[] numbersD = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sumOfEvenD = Arrays.stream(numbersD)
                .filter(x -> x % 2 ==0)
                .sum();

        System.out.println(sumOfEvenD);
         */
        // функциональное программирование - одно из форм декларативного программирования
        /**
         * 02.1 Императивное: найти сумму всех чисел больше 5 в списке (сами прописали)
         */
        /*
        int[] numbers = new int[] {1, 6, 3, 8, 5, 10, 7};
        int sumOfNumAbove5 = 0;
        */
        /*
        for (int i : numbers) {
            if (i > 5) {
                sumOfNumAbove5 +=i;
            }
        }
         */
        /**
         * 02.2 Декларативное: найти сумму всех чисеб больше 5 в списке (встроен. функц)
         */
        /*
        sumOfNumAbove5 = Arrays.stream(numbers)
                .filter(x -> x > 5)
                .sum();
        System.out.println(sumOfNumAbove5);
        */
        /*
        int[] numbers = new int[] {1, 6, 3, 8, 5, 10, 7};
        System.out.println("Array before sort: " + Arrays.toString(numbers));
         */
        /**
         * 03.1 Импертаивное: сортировка пузырьком
         */
        /*
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++){
                if (numbers[j] < numbers[i]){
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }
         */
        /**
         * 03.2 Декларативное: сортировка пузырьком
         */
        /*
        Arrays.sort(numbers);
        */
        /*
        System.out.println("Array after sort: " + Arrays.toString(numbers));
        */
        /**
         * 04.1 Императивное: сортировка подсчетом (создали отдельный метод counsort за пределом мэйна)
         */
        /*
        `arr` ——> входной целочисленный массив для сортировки
        `k` ——> такое число, что все целые числа находятся в диапазоне `0…k-1`
        */
        int[] arr = { 4, 2, 10, 10, 1, 4, 2, 1, 10 };

        // диапазон элементов массива
        int k = 10;

        countsort(arr, k);
        System.out.println(Arrays.toString(arr));
        /**
         * 04.2 Декларативное: сортировка подсчетом
         * Нет встроенных методов, только создаем сами, которой мы в дальнейшем
         * будем пользоваться. Видно определенный потолок декларативных методов.
         */
    }
    public static void countsort(int[] arr, int k)
    {
        // создаем целочисленный массив размера `n` для хранения отсортированного массива
        int[] output = new int[arr.length];

        // создать целочисленный массив размером `k + 1`, инициализированный всеми нулями
        int[] freq = new int[k + 1];

        // используя значение каждого элемента входного массива в качестве индекса,
        // сохраняем счетчик каждого целого числа в `freq[]`
        for (int i: arr) {
            freq[i]++;
        }

        // вычисляем начальный индекс для каждого целого числа
        int total = 0;
        for (int i = 0; i < k + 1; i++)
        {
            int oldCount = freq[i];
            freq[i] = total;
            total += oldCount;
        }

        // копируем в выходной массив, сохраняя порядок входов с одинаковыми ключами
        for (int i: arr)
        {
            output[freq[i]] = i;
            freq[i]++;
        }

        // копируем выходной массив обратно во входной массив
        Arrays.setAll(arr, i -> output[i]);
    }
}
