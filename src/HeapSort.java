import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] initArray;
        initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
    public static void buildTree(int[] tree, int sortLength, int i) {
        // Введите свое решение ниже
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < sortLength && tree[l] > tree[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < sortLength && tree[r] > tree[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = tree[i];
            tree[i] = tree[largest];
            tree[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            buildTree(tree, sortLength, largest);
        }
    }
    public static void heapSort(int[] sortArray, int sortLength) {
// Введите свое решение ниже
        int n = sortLength;
        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            buildTree(sortArray, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            buildTree(sortArray, i, 0);
        }

    }
}
