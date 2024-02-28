import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = readArrayFromFile("C:/Users/carlo/OneDrive/Documentos/ADS_Carlos/Java/Projeto_sort/Ordenados.txt");

            quickSort(array, 0, array.length - 1);

            System.out.println("\nArray ordenado:");
            printArray(array);
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

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
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
