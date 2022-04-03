package etu.unice.revisio;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ListOfFile {
    ArrayList<File> list;

    public ListOfFile() {
        list = new ArrayList<File>();
    }

    public int size(){
        return list.size();
    }
    public File get(int pos){
        return list.get(pos);
    }
    public void createList(Context context) {
        try {
            JSONArray jsonArray = new JSONArray(getJSONFromAsset(context));
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(getFileFromJSONObject(jsonArray.getJSONObject(i), context));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static String getJSONFromAsset(Context context) {
        String json;
        try {
            InputStream is = context.getAssets().open("revision.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private static File getFileFromJSONObject(JSONObject jsonObject, Context context) throws JSONException {
        String name = jsonObject.getString("name");
        String color = jsonObject.getString("color");

        List<Questions> questions = new ArrayList<>();

        for(int i = 0; i < jsonObject.getJSONArray("questions").length(); i++) {
            Questions getAllQuestions = new Questions(
                    jsonObject.getJSONArray("questions").getJSONObject(i).getString("label"),
                    jsonObject.getJSONArray("questions").getJSONObject(i).getString("answer1"),
                    jsonObject.getJSONArray("questions").getJSONObject(i).getString("answer2"),
                    jsonObject.getJSONArray("questions").getJSONObject(i).getString("answer3"),
                    jsonObject.getJSONArray("questions").getJSONObject(i).getString("value")
            );
            questions.add(getAllQuestions);
        }

        return new File(name, color, (ArrayList<Questions>) questions);
    }


}
