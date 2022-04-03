package etu.unice.revisio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class File implements Parcelable {
    private String name;
    private String color;
    private ArrayList<Questions> questions;

    public File(String name, String color, ArrayList<Questions> questions) {
        this.name = name;
        this.color = color;
        this.questions = questions;
    }

    protected File(Parcel in) {
        name = in.readString();
        color = in.readString();
        questions = in.createTypedArrayList(Questions.CREATOR);
    }

    public static final Creator<File> CREATOR = new Creator<File>() {
        @Override
        public File createFromParcel(Parcel in) {
            return new File(in);
        }

        @Override
        public File[] newArray(int size) {
            return new File[size];
        }
    };

    public static Creator<File> getCreator() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(color);
        parcel.writeTypedList(questions);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Questions> questions) {
        this.questions = questions;
    }

    public static Creator<File> getCREATOR() {
        return CREATOR;
    }
}
