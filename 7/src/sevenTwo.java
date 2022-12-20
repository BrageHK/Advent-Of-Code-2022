import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// star 2
public class sevenTwo {

    public static void main(String[] args) {
        Dir thisDir = new Dir("/");
        Dir root = thisDir;

        try {
            File file = new File("input.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            reader.readLine();

            while(true) {
                line = reader.readLine();
                System.out.println(line);
                if(line == null) {
                    break;
                }
                if(line.charAt(0) == '$') {
                    if(line.startsWith("cd", 2)) {
                        if(line.startsWith("..", 5)) {
                            thisDir = thisDir.outerDir;
                        } else {
                            thisDir = thisDir.findDir(line.substring(5));
                        }
                    }
                } else if(line.startsWith("dir")){
                    thisDir.innerDir.add(new Dir(thisDir, line.substring(4)));
                } else {
                    thisDir.addFile(Integer.parseInt(line.split(" ")[0]), line.split(" ")[1]);
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> sizes = new ArrayList<>();
        int freeSpace = 70000000 - root.getFileSize(sizes);

        int smallest = Integer.MAX_VALUE;
        sizes.clear();
        root.getFileSize2(sizes, freeSpace);
        for (int i: sizes) {
            if(i < smallest) {
                smallest = i;
            }

        }
        System.out.println("Free space " + freeSpace);
        System.out.println("Min number: " + (30000000 - freeSpace));
        System.out.println("Number: " + smallest);

    }
}