package etu.unice.revisio;

import android.app.Activity;
import android.app.Dialog;
import android.widget.Button;
import android.widget.TextView;

public class CustomPopup extends Dialog {

    private String title;
    private String subtitle;
    private Button yesButton, noButton;
    private TextView titleView, subtitleView;

    public CustomPopup(Activity activity) {
       super(activity, androidx.appcompat.R.style.Theme_AppCompat_DayNight_Dialog);
        setContentView(R.layout.my_popup_template);
        this.title = "Mon titre";
        this.subtitle = "Mon super sous-titre";
        this.yesButton = findViewById(R.id.yes);
        this.noButton = findViewById(R.id.no);
        this.titleView = findViewById(R.id.title);
        this.subtitleView = findViewById(R.id.subTitle);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Button getYesButton() {
        return yesButton;
    }

    public Button getNoButton() {
        return noButton;
    }

    public void build() {
        show();
        titleView.setText(title);
        subtitleView.setText(subtitle);
    }
}
