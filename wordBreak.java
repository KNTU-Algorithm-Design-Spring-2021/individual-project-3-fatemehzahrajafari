import java.io.*;
import java.util.*;
public class wordBreak{
    void breakString(int n, String s, Set<String> d, String answer) {
        for(int i = 1; i <= n; i++) {
            String str = s.substring(0, i);
            //if str in dictonary
            //answer +
            //remain string
            if(d.contains(str ))
            {
                if(i == n) {
                    answer += str ;
                    System.out.println(answer);
                    return;
                }
                breakString(n - i, s.substring(i,n), d, answer+str +" ");
            }
        }
    }
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        string = string.toLowerCase();
        int n = string.length();

        FileReader filedictionary = new FileReader("src/dictonary.txt");
        BufferedReader buffer = new BufferedReader(filedictionary);

        Set<String> d = new HashSet<>();

        String line;

        while ((line = buffer.readLine()) != null) {
            d.add(line);

        }

        filedictionary.close();

        wordBreak wb = new wordBreak();

        String answer="";
        wb.breakString(n, string, d, answer);

    }

}
