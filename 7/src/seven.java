import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// star 1
public class seven {

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
        root.getFileSize(sizes);
        int total = 0;
        for (int i: sizes) {
            total+=i;
        }
        System.out.println("Number: " + total);

    }
}

class Dir {
    String name;
    Dir outerDir;
    ArrayList<Dir> innerDir;
    ArrayList<Integer> files;
    ArrayList<String> fileNames;

    public Dir(Dir outerDir, String name) {
        this.name = name;
        this.outerDir = outerDir;
        this.innerDir = new ArrayList<>();
        this.files = new ArrayList<>();
        this.fileNames = new ArrayList<>();
    }

    public Dir(String name) {
        this.name = name;
        this.outerDir = null;
        this.innerDir = new ArrayList<>();
        this.files = new ArrayList<>();
        this.fileNames = new ArrayList<>();
    }

    public void addFile(int file, String name) {
        for (String fileName: fileNames) {
            if (fileName.equals(name)) {
                return;
            }
        }
        files.add(file);
        fileNames.add(name);
    }

    public int getFileSize(ArrayList<Integer> sizes) {
        int totalSize = 0;
        for (int file: files) {
            totalSize += file;
        }
        for (Dir dir: innerDir) {
            totalSize += dir.getFileSize(sizes);
        }
        if(totalSize <= 100000) {
            sizes.add(totalSize);
        }
        return totalSize;
    }

    public int getFileSize2(ArrayList<Integer> sizes, int freeSpace) {
        int totalSize = 0;
        for (int file: files) {
            totalSize += file;
        }
        for (Dir dir: innerDir) {
            totalSize += dir.getFileSize2(sizes, freeSpace);
        }
        if((30000000 - freeSpace) < totalSize) {
            sizes.add(totalSize);
        }
        return totalSize;
    }

    public Dir findDir(String name) {
        for(Dir dir: innerDir) {
            System.out.println("Inner dir name: " + dir.name);
            if(dir.name.equals(name)) {
                return dir;
            }
        }
        System.out.println("Can't find " + name);
        return null;
    }

}
