package eg.iti.pillsmanager.dosemanager.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import eg.iti.pillsmanager.R;
import eg.iti.pillsmanager.model.Dose;

public class DoseAdapter extends RecyclerView.Adapter<DoseAdapter.ViewHolder> {

    final Context context;
    List<Dose> doseList;

    Dose doseDetails;

    ImageView imageView;
    OnDoseClickListener listener;

    public DoseAdapter(Context context, OnDoseClickListener listener) {
        doseList = new ArrayList<>();
        this.context = context;
        this.listener = listener;
    }

    public void setDoseList(List<Dose> doses) {
        this.doseList = doses;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout constraintLayout;
        ImageView medicineIcon;
        TextView txtFirst;
        TextView txtSecond;
        TextView txtThird;

        View cardView;

        ImageView iconOpenAlarms;
        ImageView iconOpenEdit;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView;
            constraintLayout = cardView.findViewById(R.id.dose_container_view);
//            medicineIcon = cardView.findViewById(R.id.dose);

            txtFirst=cardView.findViewById(R.id.dose_first_row_text);
            txtSecond=cardView.findViewById(R.id.dose_second_row_text);
            txtThird=cardView.findViewById(R.id.dose_third_row_text);

//            iconOpenAlarms=cardView.findViewById(R.id.image_alarm);
//            iconOpenEdit=cardView.findViewById(R.id.check_active_disactive);

        }
    }

    @NonNull
    @Override
    public DoseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recycleView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recycleView.getContext());
        View v = inflater.inflate(R.layout.custom_row_dose, recycleView, false);
        return new DoseAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DoseAdapter.ViewHolder holder, int position) {
        doseDetails = doseList.get(position);
        applyChanges(holder, doseDetails);

        //handling three buttons we have
//        holder.iconOpenAlarms.setOnClickListener(view -> {
//            listener.openAlarms(medicineDetails);
//        });

//        holder.iconOpenEdit.setOnClickListener(view -> {
//            listener.openEdit(medicineDetails);
//        });

        holder.constraintLayout.setOnClickListener(view -> {
//            listener.openMedicine(medicineDetails);
        });

    }


    //when we add photo for icon

//    public void setImageUsingGlide(String imageUrl, ImageView imageView) {
//        Glide.with(context)
//                .load(imageUrl)
//                .apply(new RequestOptions().override(500, 500))
//                .placeholder(R.drawable.ic_launcher_background)
//                .error(R.drawable.ic_launcher_foreground).into(imageView);
//    }

    public void applyChanges(@NonNull DoseAdapter.ViewHolder holder, @NonNull Dose doseDetails) {

        imageView = holder.medicineIcon;
        holder.medicineIcon.setImageResource(R.drawable.ic_baseline_medical_services_24); //it should be modified by real image from database

        holder.txtFirst.setText(String.valueOf(doseDetails.getDose()));   //get flag and so on
        holder.txtSecond.setText(String.valueOf(doseDetails.getDoseTime()));
        holder.txtThird.setText(String.valueOf(doseDetails.getDose()));


    }

    @Override
    public int getItemCount() { if (doseList==null) return 0; return doseList.size();
    }

}


