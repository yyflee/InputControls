package com.example.inputcontrols;

import java.util.Calendar;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

public class TimePickerDialogFragment extends DialogFragment implements
		OnTimeSetListener {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);

		// Create a new instance of TimePickerDialog and return it
		return new TimePickerDialog(getActivity(), this, hour, minute,
				DateFormat.is24HourFormat(getActivity()));
	}

	@Override
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		System.out.println("Hour: " + hourOfDay + ":" + minute);
	}
}
