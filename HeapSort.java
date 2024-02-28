import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HeapSort {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] array = readArrayFromFile("C:/Users/carlo/OneDrive/Documentos/ADS_Carlos/Java/Projeto_sort/Ordenados_aleatoriamente.txt");

            heapSort(array);

            System.out.println("\nArray ordenado:");
            printArray(array);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
            
        System.out.println("\nTempo de execução: " + executionTime + " milissegundos");
    }

    private static int[] readArrayFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            String[] numbersString = line.split(",");
            int[] numbers = new int[numbersString.length];

            for (int i = 0; i < numbersString.length; i++) {
                numbers[i] = Integer.parseInt(numbersString[i]);
            }

            return numbers;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void heapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
        }
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
