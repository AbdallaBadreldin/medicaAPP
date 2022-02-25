package eg.iti.pillsmanager.displaydrug.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import eg.iti.pillsmanager.EditDrug.Edit_medActivity;
import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.addDrug.view.AddMedActivity;

public class DisplayDrug extends AppCompatActivity {
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_drug);
        imgView = findViewById(R.id.edit_button);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayDrug.this, Edit_medActivity.class);
                startActivity(intent);
            }
        });
    }
}