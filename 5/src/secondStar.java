import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class secondStar {
    public static void main(String[] args) {
        ArrayList<Stack> stacks = new ArrayList<>();
        Stack<Character> tempStack = new Stack<>();

        for(int i = 0; i < 9; i++) {
            stacks.add(new Stack<Character>());
        }

        try {
            File file = new File("input.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            boolean startMoving = false;

            while((line = reader.readLine()) != null) {
                if(!startMoving) {
                    if(line.contains("move")) {
                        startMoving = true;
                    } else if(line.contains("1")){
                        continue;
                    } else {
                        for(int i = 1; i < line.length(); i += 4) {
                            char c = line.charAt(i);
                            if(c != 32){
                                System.out.println("Char: " + line.charAt(i) + " Stack: " + i/4);
                                int stackIndex = i/4;
                                stacks.get(stackIndex).add(0, c);
                            }
                        }
                        continue;
                    }

                }
                Scanner sc = new Scanner(line);

                int moveAmount = sc.useDelimiter("[^\\d]+").nextInt();
                int moveFrom = sc.useDelimiter("[^\\d]+").nextInt()-1;
                int moveTo = sc.useDelimiter("[^\\d]+").nextInt()-1;
                sc.close();
                System.out.println("MoveAmount " + moveAmount+" moveFrom: "+moveFrom + " Moveto: " + moveTo);
                for(int i = 0; i < moveAmount; i++) {
                    tempStack.add((char)stacks.get(moveFrom).pop());
                }
                for(int i = 0; i < moveAmount; i++) {
                    stacks.get(moveTo).add(tempStack.pop());
                }
            }
            System.out.println("Letters:\n");
            for(int i = 0; i < 9; i++) {
                System.out.print(stacks.get(i).pop());
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

}
