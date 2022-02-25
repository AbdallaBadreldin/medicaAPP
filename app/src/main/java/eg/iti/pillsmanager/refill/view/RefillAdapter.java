package eg.iti.pillsmanager.refill.view;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.model.Medicine;

public class RefillAdapter extends RecyclerView.Adapter<RefillAdapter.ViewHolder> {
    final Context context;
    OnRefillClickListenerInterface onRefillClickListenerInterface;
    ArrayList<Medicine> activeMedicinesList;

    Medicine medicineDetails;

    ImageView medicineIcon;
    ImageView warningIcon;

    public RefillAdapter(Context context,OnRefillClickListenerInterface onRefillClickListenerInterface)
    {
        activeMedicinesList = new ArrayList<>();
        this.context=context;
        this.onRefillClickListenerInterface = onRefillClickListenerInterface;
    }

    public void setRefillMedicinesList(ArrayList<Medicine> medicines) {
        this.activeMedicinesList = medicines;
    }
//implements View.OnClickListener
    public static class ViewHolder extends RecyclerView.ViewHolder {
//implements View.OnClickListener {
        ConstraintLayout constraintLayout;
        ImageView medicineIcon;
        ImageView alarmIcon;

        CheckBox activeDisactiveBox;

        TextView txtFirst;
        TextView txtSecond;
        TextView txtThird;

        View cardView;

//        OnRefillClickListenerInterface onRefillClickListenerInterface;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView;
            constraintLayout = cardView.findViewById(R.id.refillConstrainLayout);
            medicineIcon =cardView.findViewById(R.id.refill_image_medicine);
            alarmIcon = cardView.findViewById(R.id.refill_image_alarm);
            activeDisactiveBox = cardView.findViewById(R.id.check_active_disactive);

            txtFirst=cardView.findViewById(R.id.refill_first_row_text);
            txtSecond=cardView.findViewById(R.id.refill_second_row_text);
            txtThird=cardView.findViewById(R.id.refill_third_row_text);
//            activeDisactiveBox.setOnClickListener(this);
//            constraintLayout.setOnClickListener(this);

//            activeDisactiveBox.setOnClickListener(view -> {
//                onRefillClickListenerInterface.changeRefillReminderStatus(medicineDetails,holder.activeDisactiveBox);
//            });
//
//            constraintLayout.setOnClickListener(view -> {
//                onRefillClickListenerInterface.refillMedicine(medicineDetails);
//            });
        }

//    @Override
//    public void onClick(View view) {
//
//    }

//        @Override
//        public void onClick(View view) {
//            if (view.getId() == activeDisactiveBox.getId()) {
//                onRefillClickListenerInterface
//            }
//            if (view.getId() == constraintLayout.getId()) {
//
//            }
//
//        }

    }

    @NonNull
    @Override
    public RefillAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.custom_row_refill, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i("Tag", "onBindViewHolder: " + position);
        medicineDetails =activeMedicinesList.get(position);
        applyChanges(holder, medicineDetails);

//            holder.activeDisactiveBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                    onRefillClickListenerInterface.changeRefillReminderStatus(medicineDetails);

//                }
//            });

//                    view -> {
//                onRefillClickListenerInterface.changeRefillReminderStatus(this.medicineDetails);
//                Toast.makeText(view.getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
//            });
//
//            holder.constraintLayout.setOnClickListener(view -> {
//                onRefillClickListenerInterface.refillMedicine(this.medicineDetails);
//            });

    }

    public void applyChanges(@NonNull ViewHolder holder, @NonNull Medicine medicineDetails) {

        holder.activeDisactiveBox.setChecked(medicineDetails.isActiveRefillReminder() );
       if(medicineDetails.getQuantityRemindAt()<= medicineDetails.getTotalQuantity())
        holder.alarmIcon.setImageResource(R.drawable.ic_baseline_error_outline_24);
       else holder.alarmIcon.setImageResource(R.drawable.ic_baseline_done_24);

       holder.medicineIcon.setImageResource(R.drawable.ic_baseline_medical_services_24); //it should be modified by real image from database

        holder.txtFirst.setText(String.valueOf( medicineDetails.getMedicineName()) );
        holder.txtSecond.setText(String.valueOf( medicineDetails.getTotalQuantity()) );
        holder.txtThird.setText(String.valueOf( medicineDetails.getQuantityRemindAt()) );

//        holder.activeDisactiveBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//          onRefillClickListenerInterface.changeRefillReminderStatus(medicineDetails);
//            }
//        });


        holder.activeDisactiveBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRefillClickListenerInterface.changeRefillReminderStatus(medicineDetails);
            }
        });
}



    @Override
    public int getItemCount() {
        if (activeMedicinesList==null) return 0; return activeMedicinesList.size();
    }
}
