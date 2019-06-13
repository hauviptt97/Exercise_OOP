package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.List;

public class FileUtils {

    private static Gson gson = new Gson();

    public static <T> void readJsonFile(File jsonFile, List<T> objects, Class<T> tClass) {
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

                objects.addAll(gson.fromJson(json.toString() , new TypeToken<List<Object>>(){}.getType()));

                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> void writeToJsonFile(File file, List<T> objects) {
        if (file.canWrite()) {
            FileWriter fw;
            BufferedWriter bw;

            try {
                fw = new FileWriter(file,false);
                bw = new BufferedWriter(fw);

                String json = gson.toJson(objects, new TypeToken<List<Object>>(){}.getType());
                bw.append(json);

                bw.close();
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
