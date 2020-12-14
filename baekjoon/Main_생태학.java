package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
 
public class Main_생태학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Double> map = new HashMap<>();
        double sum = 0;
        String input = "";
        while ((input=br.readLine())!=null) {
            if (map.containsKey(input)) {
                map.replace(input, map.get(input) + 1);
            } else {
                map.put(input, 1.0);
            }
            sum++;
        }
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
 
        for (String ans : list) {
            bw.write(ans + " " + String.format("%.4f", (map.get(ans) * 100 / sum))+"\n");
        }
        bw.flush();
    }
}