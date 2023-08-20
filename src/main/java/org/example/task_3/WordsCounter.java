package org.example.task_3;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordsCounter {
    public static void countWords(String pathToTxtFile) throws IOException {
        File fileTxt = new File(pathToTxtFile);
        if (!fileTxt.exists() || fileTxt.isDirectory()) {
            System.out.println("За вказаним шляхом файлу зі словами не існує!");
            return;
        }

        Scanner scanner = new Scanner(fileTxt);


        HashMap<String, Integer> map = new HashMap<>();
        String nextWord;
        while (scanner.hasNext()) {
            nextWord = scanner.next();
            if (map.containsKey(nextWord)) {
                map.replace(nextWord, map.get(nextWord) + 1);
            } else {
                map.put(nextWord, 1);
            }
        }


        scanner.close();



        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        list.sort(HashMap.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<String, Integer> wordEntry : list) {
            System.out.println(wordEntry.getKey() + " " + wordEntry.getValue());
        }
    }

    public static void main(String[] args) throws IOException {
        countWords("src/main/java/org/example/task_3/words.txt");
    }
}
