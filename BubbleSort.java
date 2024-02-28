import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BubbleSort {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] array = readArrayFromFile("C:/Users/carlo/OneDrive/Documentos/ADS_Carlos/Java/Projeto_sort/Ordenados_aleatoriamente.txt");

            bubbleSort(array);


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

    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
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
