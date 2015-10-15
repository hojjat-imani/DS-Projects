/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hojjat
 */
public class QuickSorter {
    private int[] numbers;
    private int length;
    int compares;
    public int sort(int[] values) {
        this.numbers = values;
        length = values.length;
        compares = 0;
        quicksort(0, length - 1);
        return compares;
    }
    private int quicksort(int start, int end) {
        int i = start, j = end;
        int pivot = numbers[start + (end - start) / 2];

        while (i <= j) {
            compares++;
            while (numbers[i] < pivot) {
                compares++;
                i++;
            }
            while (numbers[j] > pivot) {
                compares++;
                j--;
            }
            if (i <= j) {
                compares++;
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (start < j) {
            compares++;
            quicksort(start, j);
        }
        if (i < end) {
            compares++;
            quicksort(i, end);
        }
        return compares;
    }
    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
