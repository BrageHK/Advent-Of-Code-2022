import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FirstDay {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        try {
            File file = new File("src/input.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int calories = 0;

            while((line = reader.readLine()) != null) {
                if(line.equals("")) {
                    maxHeap.add(calories);
                    calories = 0;
                } else {
                    calories += Integer.parseInt(line);
                }
            }

            int num1 = maxHeap.poll();
            int num2 = maxHeap.poll();
            int num3 = maxHeap.poll();

            System.out.println("Highest: " + num1 + "\nTop 3: " + (num1+num2+num3));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
