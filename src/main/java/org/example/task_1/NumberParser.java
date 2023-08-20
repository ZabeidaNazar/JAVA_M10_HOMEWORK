package org.example.task_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NumberParser {
    public static final Pattern phoneRegex = Pattern.compile("(\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})");
    public static void checkNumber(String pathToFile) throws IOException {
        File file = new File(pathToFile);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("За вказаним шляхом файлу не існує!");
            return;
        }

        Scanner scanner = new Scanner(file);

        String nextLine;
        while (scanner.hasNextLine()) {
            nextLine = scanner.nextLine();
            if (phoneRegex.matcher(nextLine).matches()) {
                System.out.println(nextLine);
            }
        }

        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        checkNumber("src/main/java/org/example/task_1/file.txt");
    }
}
