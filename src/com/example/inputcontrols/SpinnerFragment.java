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

		// 创建一个ArrayList数组列表用来给Spiner控件设置数据
		List<String> list = new ArrayList<String>();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.add("item4");

		// 创建一个ArrayAdapter对象作为Spinner的适配器
		// 参数1：上下文对象
		// 参数2：下拉菜单的布局文件ID，此布局文件中必须包含一个TextView控件
		// 参数3：下拉菜单的布局文件中每一个选项的ID
		// 参数4：数据来源List对象
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
				R.layout.spinner_item, R.id.item_id, list);

		// 注释里面的代码演示的是通过在string.xml文件中定义一个字符数组，然后把数组绑定到Spinner 中，
		// 这是静态数据绑定的一个例子
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
