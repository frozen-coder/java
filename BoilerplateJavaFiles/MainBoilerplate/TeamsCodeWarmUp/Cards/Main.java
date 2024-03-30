import java.util.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;

public class Main {
    
    public static void main(String args[]) throws Exception {
        //fast input
        //CusStdBufIo io = new CusStdBufIo(new FileInputStream(new File("input.txt")));
        CusStdBufIo io = new CusStdBufIo(System.in);
        //use sb.append to append any datatype
        //fast answerset contruction
        StringBuilder sb = new StringBuilder();
        int size = io.nextInt();
        int[] nums = new int[size];
        //boolean[] cleanArray = new boolean[size];
        boolean[] visited = new boolean[size];
        LinkedList<Integer> ll = new LinkedList<>();
        long totalSum = 0;
        for(int i = 0; i < size; i++) {
            int curr = io.nextInt();
            totalSum += curr;
            nums[i] = curr;
        }
        System.out.println(size);
        boolean[] notCoprime = new boolean[size+1];
        for(int i = 2; i <= size; i++) {
            if(size % i != 0) {
                for(int j = i; j <=size; j+=i) {
                    notCoprime[j] = true;
                }
                
            }
        }
        System.out.println("Coprime Numbers");
        for(int i = 0; i < size; i++) {
            System.out.println(!notCoprime[i]);
        }
        

        //my huristic
        //if i = factor of size than i do it naivley
        //else i just return the know think
        for(int i = 1; i <= size; i++) {
            //System.out.println("Coprime? " + i + " " + size + " " + coprime(i,size));
            if(notCoprime[i]) {
                int currIndex = 0;
                long currSum = 0;
                
                while(true) {
                    if(visited[currIndex]) {
                        break;
                    }
                    currSum += nums[currIndex];
                    visited[currIndex] = true;
                    System.out.println("Visiting " + currIndex);
                    currIndex = (currIndex + i) % size;
                    ll.add(currIndex);
                }
                System.out.println("Cur Linked List Size " + ll.size());
                
                for(int j = ll.size(); j > 0; j--) {
                    Integer current = ll.pop();
                    System.out.println("Removing " + current);
                    visited[current] = false;
                }
                //System.out.println("HOI");
                sb.append(currSum);
                sb.append("\n");
            }
            else {
             sb.append(totalSum);
                sb.append("\n");
            }
        }

        //fast output
        //for best preformance only call once
        io.write(sb.toString(), System.out);
    }
    private static boolean isFactorOf(int potentialFactor, int bigBoiNumber) {
        return bigBoiNumber%potentialFactor==0;
    }
    static  int __gcd(int a, int b) {
    if (a == 0)
        return b;

    while (b != 0) {
        if (a > b)
            a = a - b;
        else
            b = b - a;
    }

    return a;
}
    static boolean coprime(int a, int b) { 
          
        if ( __gcd(a, b) == 1) 
            return true;
        else
            return false;      
    } 

}
class CusStdBufIo {
        String[] currentLine = new String[0];
        BufferedReader br;
        int curr = 0; 
        String delimiter = " ";
        public CusStdBufIo(InputStream inputStream) throws Exception{
            br = new BufferedReader(new InputStreamReader(inputStream));
           
        }
        public CusStdBufIo(InputStream inputStream, String delimiterIn) throws Exception{
            delimiter = delimiterIn;
            br = new BufferedReader(new InputStreamReader(inputStream));
            
        }
        public void readNextLine() throws Exception {
            curr = 0;
            currentLine = br.readLine().split(delimiter);
        }
        public int nextInt() throws Exception {
            String currToken = nextToken();
            return Integer.parseInt(currToken);
        }
        public String nextToken() throws Exception {
            if(curr < currentLine.length) {
                curr++;
                return currentLine[curr-1];
            }
            else {
                readNextLine();
                curr++;
                return currentLine[curr-1];
            }
        }
        //only call this once lol
        public void write(String str, OutputStream os) throws Exception {
            BufferedOutputStream bo = new BufferedOutputStream(os);
            byte[] output = str.getBytes(StandardCharsets.UTF_8);
            os.write(output, 0, output.length);
            os.flush();
        }
    }