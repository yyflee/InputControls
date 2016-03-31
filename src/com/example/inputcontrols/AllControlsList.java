package com.example.inputcontrols;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AllControlsList extends ListFragment {
	private static final DemoInfo[] DEMOS = {
			new DemoInfo(R.string.demo_title_autocompletetextview,
					R.string.demo_desc_autocompletetextview,
					AutoCompleteTextViewFragment.class),
			new DemoInfo(R.string.demo_title_datepicker,
					R.string.demo_desc_datepicker, DatePickerFragment.class),
			new DemoInfo(R.string.demo_title_spinner,
					R.string.demo_desc_spinner, SpinnerFragment.class),
					};
	private OnListViewItemClickListener mCallback = null;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// This makes sure that the container activity has implemented
		// the callback interface. If not, it throws an exception.
		try {
			mCallback = (OnListViewItemClickListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnHeadlineSelectedListener");
		}
	}

	public interface OnListViewItemClickListener {
		/**
		 * 通过调用此方法实现Fragment之间的切换动作
		 * 
		 * @param param
		 *            Fragment子类的Class对象的引用,所有Fragment的子类存放在DEMOS数组中
		 */
		void OnFragmentChanging(Class<? extends Fragment> param);
	}

	/**
	 * 自定义DemoListAdapter用于ListView.setAdapter数据的绑定时创建入参，绑定DEMOS数组数据
	 * 
	 * @author G.Lee
	 * 
	 */
	private class DemoListAdapter extends BaseAdapter {
		public DemoListAdapter() {
			super();
		}

		@Override
		public View getView(int index, View convertView, ViewGroup parent) {
			convertView = View.inflate(getContext(), R.layout.demo_info_item,
					null);
			TextView title = (TextView) convertView.findViewById(R.id.title);
			TextView desc = (TextView) convertView.findViewById(R.id.desc);
			title.setText(DEMOS[index].title);
			desc.setText(DEMOS[index].desc);
			if (index >= 16) {
				title.setTextColor(Color.YELLOW);
			}
			return convertView;
		}

		@Override
		public int getCount() {
			return DEMOS.length;
		}

		@Override
		public Object getItem(int index) {
			return DEMOS[index];
		}

		@Override
		public long getItemId(int id) {
			return id;
		}
	}

	private static class DemoInfo {
		private final int title;
		private final int desc;
		private final Class<? extends Fragment> demoClass;

		public DemoInfo(int title, int desc, Class<? extends Fragment> demoClass) {
			this.title = title;
			this.desc = desc;
			this.demoClass = demoClass;
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.allcontrolslist, container, false);

		setListAdapter(new DemoListAdapter());

		return view;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		if (mCallback != null) {
			mCallback.OnFragmentChanging(DEMOS[position].demoClass);
		}

		super.onListItemClick(l, v, position, id);
	}
}
