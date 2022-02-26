package eg.iti.pillsmanager.medicinces.view;

import android.content.Context;
import android.util.Log;
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
import eg.iti.pillsmanager.model.Medicine;

public class ActiveMedicineAdapter extends RecyclerView.Adapter<ActiveMedicineAdapter.ViewHolder> {

    final Context context;
    List<Medicine> medicinesList;

    Medicine medicineDetails;
    String genre = "";

    ImageView imageView;
    OnMedicineClickListener listener;

    public ActiveMedicineAdapter(Context context, OnMedicineClickListener listener) {
        medicinesList = new ArrayList<>();
        this.context = context;
        this.listener = listener;
    }

    public void setActiveMedicinesList(List<Medicine> medicines) {
        this.medicinesList = medicines;
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
//        Button btnOpenMedicine;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView;
            constraintLayout = cardView.findViewById(R.id.constrainLayout);
            medicineIcon = cardView.findViewById(R.id.image_medicine);

            txtFirst=cardView.findViewById(R.id.first_row_text);
            txtSecond=cardView.findViewById(R.id.second_row_text);
            txtThird=cardView.findViewById(R.id.third_row_text);

            iconOpenAlarms=cardView.findViewById(R.id.image_alarm);
            iconOpenEdit=cardView.findViewById(R.id.check_active_disactive);

        }
    }

    @NonNull
    @Override
    public ActiveMedicineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recycleView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recycleView.getContext());
        View v = inflater.inflate(R.layout.custom_row_medicine, recycleView, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        medicineDetails = medicinesList.get(position);
        applyChanges(holder, medicineDetails);

        //handling three buttons we have
        holder.iconOpenAlarms.setOnClickListener(view -> {
            listener.openAlarms(medicineDetails);
        });

        holder.iconOpenEdit.setOnClickListener(view -> {
            listener.openEdit(medicineDetails);
        });

        holder.constraintLayout.setOnClickListener(view -> {
            listener.openMedicine(medicineDetails);
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

    public void applyChanges(@NonNull ViewHolder holder, @NonNull Medicine medicineDetails) {

        imageView = holder.medicineIcon;
        holder.medicineIcon.setImageResource(R.drawable.ic_baseline_medical_services_24); //it should be modified by real image from database

        holder.txtFirst.setText(String.valueOf(medicineDetails.getMedicineName()));
        holder.txtSecond.setText(String.valueOf(medicineDetails.getTotalQuantity()));
        holder.txtThird.setText(String.valueOf(medicineDetails.getStrength())+String.valueOf(medicineDetails.getStrengthValue()));

//        setImageUsingGlide(medicineDetails.getImageURL(), imageView);

        //this piece of code get genereArray and make it one nice String to show it
//        for (int j = 0; j < movieDetails.getGenre().size(); j++) {
//            if (j == movieDetails.getGenre().size() - 1) {
//                genre += movieDetails.getGenre().get(j);
//            } else {
//                genre = genre.concat(movieDetails.getGenre().get(j) + ", ");
//            }
//        }


        //set your values from incoming data from room and online

        /*  medicine not ready yet tooooooooooooooooooooooooooooooooooooooooooooooooooooo bad     */
//        holder.txtFirst.setText();

//        holder.txtGenre.setText(genre);
//        genre = "";
//        holder.txtReleaseYear.setText(String.valueOf(movieDetails.getReleaseYear()));
//        holder.txtTitle.setText(movieDetails.getTitle());
//        holder.ratingBar.setProgress((int) movieDetails.getRating());


    }

    @Override
    public int getItemCount() { if (medicinesList==null) return 0; return medicinesList.size();
    }

}

