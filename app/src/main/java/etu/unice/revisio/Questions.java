package etu.unice.revisio;


import android.os.Parcel;
import android.os.Parcelable;

public class Questions implements Parcelable {
    private String label;
    private String answer1;
    private String answer2;
    private String answer3;
    private String value;

    public Questions(String label, String answer1, String answer2, String answer3, String value) {
        this.label = label;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.value = value;
    }

    protected Questions(Parcel in) {
        label = in.readString();
        answer1 = in.readString();
        answer2 = in.readString();
        answer3 = in.readString();
        value = in.readString();
    }

    @Override
    public String toString() {
        return getLabel();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(label);
        dest.writeString(answer1);
        dest.writeString(answer2);
        dest.writeString(answer3);
        dest.writeString(value);
    }

    public static Creator<Questions> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Questions> CREATOR = new Creator<Questions>() {
        @Override
        public Questions createFromParcel(Parcel in) {
            return new Questions(in);
        }

        @Override
        public Questions[] newArray(int size) {
            return new Questions[size];
        }
    };

    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
