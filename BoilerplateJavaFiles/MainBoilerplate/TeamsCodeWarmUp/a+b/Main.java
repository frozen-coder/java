import java.util.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    
    public static void main(String args[]) throws Exception {
        //fast input
        CusStdBufIo io = new CusStdBufIo(System.in);
        //use sb.append to append any datatype
        //fast answerset contruction
        StringBuilder sb = new StringBuilder();
        int ans = io.nextInt() + io.nextInt();
        sb.append(ans);
        //fast output
        //for best preformance only call once
        io.write(sb.toString(), System.out);
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
            return Integer.parseInt(nextToken());
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