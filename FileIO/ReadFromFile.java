import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadFromFile {
    public static void main(String[] args) throws Exception{
        BufferedReader br = null;
        BufferedWriter wr = null;
        wr = new BufferedWriter(new FileWriter(new File("out.txt")));
        br = new BufferedReader(new FileReader(new File("in.txt")));
        String s;
        ArrayList<String> words = new ArrayList<>();
        int count = 1;
        while((s = br.readLine()) != null) {
            String[] singleWord = s.split(" ");
            words.addAll(Arrays.asList(singleWord));
        }
        for(int i=0; i<words.size(); i+=count) {
            if(words.get(i).isEmpty()) continue;
            for(int j=i+1; j<words.size(); j++) {
                if(words.get(i).equals(words.get(j))) {
                    count++;
                    words.set(j, "");
                }
            }
            wr.append(words.get(i)).append(" occured ").append(String.valueOf(count)).append(" times.").append("\n");
            count = 1;
            words.set(i, "");
        }
        br.close();
        wr.close();
    }

}