package eg.iti.pillsmanager.displaydrug.view;

import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import eg.iti.pillsmanager.EditDrug.Edit_medActivity;
import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.addDrug.view.AddMedActivity;
import eg.iti.pillsmanager.database.LocalSource;
import eg.iti.pillsmanager.medicinces.view.MediciationsFragment;
import eg.iti.pillsmanager.model.Medicine;
import eg.iti.pillsmanager.model.Repository;
import eg.iti.pillsmanager.network.NetworkDelegate;
import eg.iti.pillsmanager.network.RemoteSource;

public class DisplayDrug extends AppCompatActivity {
    ImageView imgView,deleteBtn,back_btn;
    TextView drug_name,drug_dose,reminder_val,reason_val,pills_left,when_to_refill;
    Repository repo;
    RemoteSource remoteSource;
    LocalSource localSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_drug);
        back_btn = findViewById(R.id.back_button);
        drug_name= findViewById(R.id.drug_name);
        drug_dose=findViewById(R.id.drug_dose);
        reminder_val=findViewById(R.id.reminders_val);
        reason_val=findViewById(R.id.reason_val);
        pills_left=findViewById(R.id.pills_left);
        when_to_refill =findViewById(R.id.when_to_refill);
        deleteBtn =findViewById(R.id.delete_button);


        Intent intent = getIntent();
        Medicine medicine = (Medicine) intent.getSerializableExtra("med");

        repo = Repository.getInstance(remoteSource, localSource, this);
        drug_name.setText(medicine.getMedicineName());
        drug_dose.setText("" + medicine.getStrengthValue());
        reason_val.setText(medicine.getReason());
        pills_left.setText("" + medicine.getLastdoseQuantity());
        when_to_refill.setText("" + medicine.getQuantityRemindAt());

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(DisplayDrug.this,Edit_medActivity.class));
                Intent intent = new Intent(DisplayDrug.this,  MediciationsFragment.class);
                finish();
               /* intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT );
                intent.putExtra("med",medicine);
                startActivity(intent);*/

            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             repo.deleteMedicine(medicine);
                                             finish();
                                         }
                                     }
        );




    }
}