package eg.iti.pillsmanager.pickdependent.view;

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
import eg.iti.pillsmanager.model.User;

public class PickDependentAdapter extends RecyclerView.Adapter<PickDependentAdapter.ViewHolder> {

    final Context context;
    List<User> usersList;

    User userDetails;

    OnPickUserClickListener listener;

    public PickDependentAdapter(Context context, OnPickUserClickListener listener) {
        usersList = new ArrayList<>();
        this.context = context;
        this.listener = listener;
    }

    public void setActiveUsersList(List<User> users) {
        this.usersList = users;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout constraintLayout;
        ImageView medicineIcon;
        TextView txtFirst;
        TextView txtSecond;
        TextView txtThird;

        View cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView;
            constraintLayout = cardView.findViewById(R.id.userConstrainLayout);
            medicineIcon = cardView.findViewById(R.id.uesr_image);

            txtFirst=cardView.findViewById(R.id.user_name);
            txtSecond=cardView.findViewById(R.id.user_gender);
            txtThird=cardView.findViewById(R.id.user_age);

        }
    }

    @NonNull
    @Override
    public PickDependentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recycleView, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(recycleView.getContext());
        View v = inflater.inflate(R.layout.custom_row_user, recycleView, false);
        return new PickDependentAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PickDependentAdapter.ViewHolder holder, int position) {
        userDetails = usersList.get(position);
        applyChanges(holder, userDetails);

        //handling three buttons we have
        holder.constraintLayout.setOnClickListener(view -> {
            listener.pickUser(userDetails);
        });


    }

    public void applyChanges(@NonNull PickDependentAdapter.ViewHolder holder, @NonNull User userDetails) {

//        imageView = holder.medicineIcon;
//        holder.medicineIcon.setImageResource(R.drawable.u); //it should be modified by real image from database

        holder.txtFirst.setText(String.valueOf(userDetails.getFirstName()));
        holder.txtSecond.setText(String.valueOf(userDetails.getGender()));
        holder.txtThird.setText(String.valueOf(userDetails.getAge()));

    }

    @Override
    public int getItemCount() { if (usersList ==null) return 0; return usersList.size();
    }

}

