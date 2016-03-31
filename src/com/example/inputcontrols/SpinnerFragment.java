package com.example.inputcontrols;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



public class SpinnerFragment extends Fragment implements OnItemSelectedListener {
	private Spinner spinner = null;

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.spinner_fragment, container,
				false);

		spinner = (Spinner) view.findViewById(R.id.planets_spinner);

		// ����һ��ArrayList�����б�������Spiner�ؼ���������
		List<String> list = new ArrayList<String>();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");

		// ����һ��ArrayAdapter������ΪSpinner��������
		// ����1�������Ķ���
		// ����2�������˵��Ĳ����ļ�ID���˲����ļ��б������һ��TextView�ؼ�
		// ����3�������˵��Ĳ����ļ���ÿһ��ѡ���ID
		// ����4��������ԴList����
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
				R.layout.spinner_item, R.id.item_id, list);

		// ע������Ĵ�����ʾ����ͨ����string.xml�ļ��ж���һ���ַ����飬Ȼ�������󶨵�Spinner �У�
		// ���Ǿ�̬���ݰ󶨵�һ������
		// Create an ArrayAdapter using the string array and a default
		// spinner layout ArrayAdapter<CharSequence> adapter =
		// ArrayAdapter.createFromResource(this,
		// R.array.planets_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		return view;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		String item = parent.getItemAtPosition(position).toString();
		System.out.println("Selected:" + item);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		System.out.println("nothing selected.");
	}

}
