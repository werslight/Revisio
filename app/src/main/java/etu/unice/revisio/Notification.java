package etu.unice.revisio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Notification extends AppCompatActivity {
    EditText editNumber, editMessage;
    Button btnSendMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        btnSendMessage = findViewById(R.id.btnSendMessage);
        editNumber = findViewById(R.id.editNumber);
        editMessage = findViewById(R.id.editMessage);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("smsto:"));
                    i.setType("vnd.android-dir/mms-sms");
                    i.putExtra("address", new String(editNumber.getText().toString()));
                    i.putExtra("sms_body", editMessage.getText().toString());
                    startActivity(Intent.createChooser(i, "Send sms via:"));


                }
                catch (Exception e){
                    Toast.makeText(Notification.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

