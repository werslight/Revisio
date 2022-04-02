package etu.unice.revisio;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ListCategory {
    ArrayList<Category> list;

    public ListCategory() {
        list = new ArrayList<Category>();
    }

    public int size(){
        return list.size();
    }
    public Category get(int pos){
        return list.get(pos);
    }
    public void createList(Context context) {
        try {
            JSONArray jsonArray = new JSONArray(getJSONFromAsset(context));

            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(getCategoryFromJSONObject(jsonArray.getJSONObject(i), context));
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

    private static Category getCategoryFromJSONObject(JSONObject jsonObject, Context context) throws JSONException {
        String name = jsonObject.getString("name");
        int color = jsonObject.getInt("color");

        List<File> files = new ArrayList<>();
        List<Questions> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        for(int i = 0; i < jsonObject.getJSONArray("files").length(); i++) {
            File getAllFiles = new File(
                    jsonObject.getJSONArray("files").getJSONObject(i).getString("name"),
                    jsonObject.getJSONArray("files").getJSONObject(i).getInt("color"),
                    jsonObject.getJSONArray("files").getJSONObject(i).getJSONArray("answers")
            );

            files.add(getAllFiles);
        }
        return new Category(String name, int color);
    }
}
