package eg.iti.pillsmanager.displaydrug.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import eg.iti.pillsmanager.EditDrug.Edit_medActivity;
import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.addDrug.view.AddMedActivity;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;

public class DisplayDrug extends AppCompatActivity {
    ImageView imgView,deleteBtn;
    TextView drug_name,drug_dose,reminder_val,reason_val,pills_left,when_to_refill;
    Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_drug);
        imgView = findViewById(R.id.edit_button);
        drug_name= findViewById(R.id.drug_name);
        drug_dose=findViewById(R.id.drug_dose);
        reminder_val=findViewById(R.id.reminders_val);
        reason_val=findViewById(R.id.reason_val);
        pills_left=findViewById(R.id.pills_left);
        when_to_refill =findViewById(R.id.when_to_refill);
        deleteBtn =findViewById(R.id.delete_button);

        Intent intent = getIntent();
        Medicine medicine= (Medicine) intent.getSerializableExtra("med");


        drug_name.setText(medicine.getMedicineName());
        drug_dose.setText(""+medicine.getStrengthValue());
        reason_val.setText(medicine.getReason());
        pills_left.setText(medicine.getLastdoseQuantity());
        when_to_refill.setText(""+medicine.getQuantityRemindAt());

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {

                                         }
                                     }
        );




    }
}