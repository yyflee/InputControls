package com.example.inputcontrols;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoCompleteTextViewFragment extends Fragment {
	private AutoCompleteTextView autoCompleteTextView = null;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.autocompletetextview_fragment,
				container, false);
		autoCompleteTextView = (AutoCompleteTextView) view
				.findViewById(R.id.autocompletetextview);
		List<String> list = new ArrayList<String>();
		list.add("abcde");
		list.add("abdedf");
		ArrayAdapter<String> adpater = new ArrayAdapter<>(getContext(),
				R.layout.autocompletetextview_item, list);
		autoCompleteTextView.setAdapter(adpater);		
		return view;
	}

}
