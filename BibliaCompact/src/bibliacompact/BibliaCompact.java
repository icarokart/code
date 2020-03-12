package bibliacompact;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class BibliaCompact {

    public static void main(String[] args) throws IOException {
        File text = new File("bible.txt");
        File output = new File("result.txt");
        File mapper = new File("mapper.txt");
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        try {
            Scanner sc = new Scanner(text);
            FileWriter w = new FileWriter(output);
            FileWriter m = new FileWriter(mapper);
            Integer i = 0;
            while (sc.hasNext()) {
                String linha = sc.nextLine();
                String[] palavras = linha.split(" ");
                int j = 0;
                for (String p : palavras) {
                    if (j != 0) {
                        if (!words.containsKey(p)) {
                            words.put(p, i);
                            i++;
                            m.write(p);
                            m.write(" ");
                            m.write(i.toString());
                            m.write(" ");
                        }
                        w.write(Integer.toHexString(words.get(p)).toString());
                        w.write(" ");
                    }
                    j++;
                }

            }
            m.close();
            sc.close();
            w.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
