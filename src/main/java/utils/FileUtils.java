package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.exercise03.Student;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {

    private static Gson gson = new Gson();

    public static <T> void readJsonFile(File jsonFile, List<T> objects, Type typeOfT) {
        FileReader fr;
        BufferedReader br;

        if (jsonFile.canRead()) {
            try {
                fr = new FileReader(jsonFile);
                br = new BufferedReader(fr);
                String dataRow;

                StringBuilder json = new StringBuilder();

                while ((dataRow = br.readLine()) != null) {
                    json.append(dataRow);
                }

                objects.clear();


                objects.addAll(gson.fromJson(json.toString(), typeOfT));

                br.close();
                fr.close();
            } catch (IOException ignored) {
            }
        }
    }

    public static <T extends Object> void writeToJsonFile(File file, List<T> objects, Type typeOfT) {
        if (file.canWrite()) {
            FileWriter fw;
            BufferedWriter bw;

            try {
                fw = new FileWriter(file, false);
                bw = new BufferedWriter(fw);

                String json = gson.toJson(objects, typeOfT);
                bw.append(json);

                bw.close();
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
