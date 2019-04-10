package FileIO;

import java.io.*;

public class ReadFromFile {
    public static void main(String[] args) throws Exception{
        BufferedReader br = null;
        FileWriter wr = null;
        wr = new FileWriter("out.txt");
        br = new BufferedReader(new FileReader("in.txt"));
        String s;
        String[] words = null;
        int count = 1;
        while((s = br.readLine()) != null) {
            words = s.split(" ");
            for(int i=0; i<words.length; i++) {
                if(words[i].equals("")) continue;
                for(int j=i+1; j<words.length; j++) {
                    if(words[i].equals(words[j])) {
                        words[j] = "";
                        count++;
                    }
                }
                wr.append("'").append(words[i]).append("'").append(" occured ").append(String.valueOf(count)).append(" times.").append("\n");
                words[i] = "";
                count = 1;
            }
        }
        try {
            br.close();
            wr.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}