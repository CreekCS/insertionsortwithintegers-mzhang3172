import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InsSortInt {

    public static void main(String[] args) {
        int[] tall = new int[1000];

        try {
      
            tall = loadNumbersFromFile("randInts.txt");

            insertionSort(tall);

            System.out.println("Smallest number: " + tall[0]);
            System.out.println("Largest number: " + tall[tall.length - 1]);

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static int[] loadNumbersFromFile(String fileName) throws IOException {
        int[] numbers = new int[1000];
        File file = new File(fileName);
        FileReader inputFile = new FileReader(file);
        BufferedReader in = new BufferedReader(inputFile);

        String s;
        int i = 0;
        while ((s = in.readLine()) != null && i < 1000) {
            numbers[i] = Integer.parseInt(s);
            i++;
        }

        in.close();
        return numbers;
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
