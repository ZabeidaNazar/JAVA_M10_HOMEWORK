package org.example.task_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserTxtToJson {
    public static void convertData(String pathToTxtFile, String pathToJsonFile) throws IOException {
        File fileTxt = new File(pathToTxtFile);
        if (!fileTxt.exists() || fileTxt.isDirectory()) {
            System.out.println("За вказаним шляхом файлу для зчитуваняя не існує!");
            return;
        }

        Scanner scanner = new Scanner(fileTxt);

        scanner.skip("name age");

        User user;
        List<User> userList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            user = new User();
            if (scanner.hasNext()) {
                user.setName(scanner.next());
            }
            if (scanner.hasNextInt()) {
                user.setAge(scanner.nextInt());
            }
            userList.add(user);
        }

        scanner.close();


        for (User u : userList) {
            System.out.println(u);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(userList);

        FileWriter writer = new FileWriter(pathToJsonFile);
        writer.write(json);
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        convertData("src/main/java/org/example/task_2/file.txt",
                   "src/main/java/org/example/task_2/user.json");
    }
}
