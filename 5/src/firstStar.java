import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class firstStar {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();
        Stack<Integer> stack5 = new Stack<>();
        Stack<Integer> stack6 = new Stack<>();
        Stack<Integer> stack7 = new Stack<>();
        Stack<Integer> stack8 = new Stack<>();
        Stack<Integer> stack9 = new Stack<>();



    }


    private void readFile(String fileName) {
        try {
            File file = new File("src/input.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int calories = 0;

            while((line = reader.readLine()) != null) {
                if(line.equals("")) {

                } else {

                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
