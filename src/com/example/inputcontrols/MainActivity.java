package com.example.inputcontrols;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.inputcontrols.AllControlsList.OnListViewItemClickListener;

public class MainActivity extends FragmentActivity implements
		OnListViewItemClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new AllControlsList()).commit();
		}
	}

	@Override
	public void OnFragmentChanging(Class<? extends Fragment> param) {
		try {
			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			ft.replace(R.id.container, param.newInstance());
			ft.addToBackStack(null);
			ft.commit();			
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
		}
	}
}
