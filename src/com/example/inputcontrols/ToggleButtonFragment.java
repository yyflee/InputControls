package com.example.inputcontrols;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;


public class ToggleButtonFragment extends Fragment implements OnCheckedChangeListener{

	private Switch mSwitch;
    private ToggleButton mToggleButton;
    
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.togglebutton_fragment, container, false);
		mToggleButton = (ToggleButton)view.findViewById(R.id.togglebutton);
		mSwitch = (Switch)view.findViewById(R.id.switchbtn);
		mToggleButton.setOnCheckedChangeListener(this);
		mSwitch.setOnCheckedChangeListener(this);
		return view;
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		switch (buttonView.getId()) {
		case R.id.togglebutton:
			if (isChecked) {
				Toast.makeText(getContext(), "打开(ToggleButton)", Toast.LENGTH_LONG).show();
			}
			else {
				Toast.makeText(getContext(), "关闭(ToggleButton)", Toast.LENGTH_LONG).show();
			}
			break;
		case R.id.switchbtn:
			if (isChecked) {
				Toast.makeText(getContext(), "打开(Switch)", Toast.LENGTH_LONG).show();
			}
			else {
				Toast.makeText(getContext(), "关闭(Switch)", Toast.LENGTH_LONG).show();
			}
			break;
		default:
			break;
		}
		
		
	}
	
}
