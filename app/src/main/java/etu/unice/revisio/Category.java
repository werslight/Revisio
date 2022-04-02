package etu.unice.revisio;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Category implements Parcelable {
    private String name;
    private int color;
    private ArrayList<File> files;

    public Category(String name, int color, ArrayList<File> files) {
        this.name = name;
        this.color = color;
        this.files = files;
    }

    protected Category(Parcel in) {
        name = in.readString();
        color = in.readInt();
        files = in.createTypedArrayList(File.CREATOR);
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    public static Creator<Category> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(color);
        parcel.writeTypedList(files);
    }

    public static Creator<Category> getCreator() {
        return CREATOR;
    }

}
