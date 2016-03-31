package com.example.inputcontrols;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DatePickerFragment extends Fragment implements
		android.view.View.OnClickListener {
	private Button btnShowDatePickerDialog, btnShowTimePickerDialog;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.datepicker_fragment, container,
				false);
		btnShowDatePickerDialog = (Button) view
				.findViewById(R.id.btnShowDatePickerDialog);
		btnShowDatePickerDialog.setOnClickListener(this);
		btnShowTimePickerDialog = (Button) view
				.findViewById(R.id.btnShowTimePickerDialog);
		btnShowTimePickerDialog.setOnClickListener(this);
		
		return view;
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnShowDatePickerDialog:{
			DialogFragment datePickerFragment = new DatePickerDialogFragment();
			datePickerFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
			break;
		}
		case R.id.btnShowTimePickerDialog:{
			TimePickerDialogFragment tp = new TimePickerDialogFragment();
			tp.show(getActivity().getSupportFragmentManager(), "timePicker");
			break;
		}

		default:
			break;
		}
	}
}
