package HW01;

import java.util.Arrays;
import java.util.Collections;

public class MainHW01 {
    public static void main(String[] args) {

        Integer[] numbers = new Integer[] {5, 3 ,13, 27, 1, 8};
        System.out.println("Array before sort: " + Arrays.toString(numbers));
        /**
         * 01. Дан список целых чисел numbers. Необходимо написать в императивном стиле
         * процедуру для сортировки числа в списке в порядке убывания. Можно использовать
         * любой алгоритм сортировки.
         */
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1 ; j < n; j++) {
                if (numbers[i] < numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println("Array after sort (imperative): " + Arrays.toString(numbers));
        /**
         * 02. Написать точно такую же процедуру, но в декларативном стиле
         */
        Arrays.sort(numbers, Collections.reverseOrder());

        System.out.println("Array after sort (declarative): " + Arrays.toString(numbers));
    }
}
