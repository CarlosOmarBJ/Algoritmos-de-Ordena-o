import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InsertionSort {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] array = readArrayFromFile("C:/Users/carlo/OneDrive/Documentos/ADS_Carlos/Java/Projeto_sort/Ordenados_aleatoriamente.txt");

            insertionSort(array);

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

    private static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
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
