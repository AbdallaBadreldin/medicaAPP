package eg.iti.pillsmanager.refill.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.model.Medicine;

public class RefillAdapter extends RecyclerView.Adapter<RefillAdapter.ViewHolder> {
    final Context context;
    OnRefillClickListenerInterface onRefillClickListenerInterface;
    ArrayList<Medicine> activeMedicinesList;

    Medicine medicineDetails;

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
            txtThird=cardView.findViewById(R.id.dose_third_row_text);

        }
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
        medicineDetails =activeMedicinesList.get(position);
        applyChanges(holder, medicineDetails);

    }

    public void applyChanges(@NonNull ViewHolder holder, @NonNull Medicine medicineDetails) {

        holder.activeDisactiveBox.setChecked( medicineDetails.isActiveRefillReminder() );

        if(medicineDetails.getQuantityRemindAt()>=medicineDetails.getTotalQuantity() )
        holder.alarmIcon.setImageResource(R.drawable.ic_baseline_error_outline_24);
       else holder.alarmIcon.setImageResource(R.drawable.ic_baseline_done_24);

       holder.medicineIcon.setImageResource(R.drawable.ic_baseline_medical_services_24); //it should be modified by real image from database

        holder.txtFirst.setText(String.valueOf( medicineDetails.getMedicineName() ));
        holder.txtSecond.setText(String.valueOf(  context.getString(R.string.quantity)+medicineDetails.getTotalQuantity() ));
        holder.txtThird.setText(String.valueOf( context.getString(R.string.reminderer)+ medicineDetails.getQuantityRemindAt() ));


        holder.activeDisactiveBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRefillClickListenerInterface.changeRefillReminderStatus(medicineDetails);
            }
        });

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRefillClickListenerInterface.refillMedicine(medicineDetails);
            }
        });
}

    @Override
    public int getItemCount() {
        if (activeMedicinesList==null) return 0; return activeMedicinesList.size();
    }
}
