package eg.iti.pillsmanager.refill.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import eg.iti.pillsmanager.R;

public class RefillDialogFragment extends DialogFragment {

    public RefillDialogInterface mOnInputListener;

    private EditText totalQuantityInput, remindAtQuantityInput;
    private TextView mActionOk, mActionCancel;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.refill_dialog_fragment, container, true);
        mActionCancel = view.findViewById(R.id.refill_dialog_action_cancel);
        mActionOk = view.findViewById(R.id.refill_dialog_action_ok);
        totalQuantityInput = view.findViewById(R.id.total_quantity_edit);
        remindAtQuantityInput = view.findViewById(R.id.reminder_at_edit);

        mActionCancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getDialog().dismiss();
                    }
                });

        mActionOk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String totalQuantityInputString
                                = totalQuantityInput.getText().toString().trim();

                        String remindAtQuantityInputString
                                = remindAtQuantityInput.getText().toString().trim();

                        if (!(totalQuantityInputString.isEmpty() || remindAtQuantityInputString.isEmpty())) {
                            if (mOnInputListener instanceof RefillFragment) {
                                mOnInputListener.sendTotalQuantity(Integer.parseInt(totalQuantityInputString));
                                mOnInputListener.sendRemindAtQuantity(Integer.parseInt(remindAtQuantityInputString));
                            } else
                                Toast.makeText(getContext(), getContext().getString(R.string.enter_both_fields), Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getContext(), getContext().getString(R.string.please_enter_valid_data), Toast.LENGTH_SHORT).show();

                        getDialog().dismiss();
                    }
                });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mOnInputListener
                    = (RefillDialogInterface) getParentFragmentManager().getPrimaryNavigationFragment();
        } catch (ClassCastException e) {
            Toast.makeText(context, getString(R.string.error_call_developer), Toast.LENGTH_SHORT).show();
        }
    }


}