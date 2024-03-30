import java.io.FileOutputStream;
import java.io.File;
import java.io.PrintStream;
public class CaseGenerator {
    public static void main(String[] args) throws Exception {
        int size=  20000;
        System.setOut(new PrintStream(new File("input.txt")));
        System.out.println(size + " ");
        for(int i = 1; i <= size; i++) {
            System.out.print(i + " ");
        }
    }
}