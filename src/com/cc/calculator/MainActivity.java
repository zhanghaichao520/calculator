package com.cc.calculator;

import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private TextView tvScreen;
	private List<Item> Items = new ArrayList<Item>();
	private double val1;
	private double val2;
	private String rs="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initevents();
	}

	private void initevents() {
		tvScreen = (TextView) findViewById(R.id.tvScreen);
		findViewById(R.id.btn_0).setOnClickListener(this);
		findViewById(R.id.btn_1).setOnClickListener(this);
		findViewById(R.id.btn_2).setOnClickListener(this);
		findViewById(R.id.btn_3).setOnClickListener(this);
		findViewById(R.id.btn_4).setOnClickListener(this);
		findViewById(R.id.btn_5).setOnClickListener(this);
		findViewById(R.id.btn_6).setOnClickListener(this);
		findViewById(R.id.btn_7).setOnClickListener(this);
		findViewById(R.id.btn_8).setOnClickListener(this);
		findViewById(R.id.btn_9).setOnClickListener(this);
		findViewById(R.id.btn_Add).setOnClickListener(this);
		findViewById(R.id.btn_Sub).setOnClickListener(this);
		findViewById(R.id.btn_X).setOnClickListener(this);
		findViewById(R.id.btn_Div).setOnClickListener(this);
		findViewById(R.id.btn_Result).setOnClickListener(this);
		findViewById(R.id.btn_Clear).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		try {
			switch (v.getId()) {
			case R.id.btn_0:
				tvScreen.append("0");
				break;
			case R.id.btn_1:
				tvScreen.append("1");
				break;
			case R.id.btn_2:
				tvScreen.append("2");
				break;
			case R.id.btn_3:
				tvScreen.append("3");
				break;
			case R.id.btn_4:
				tvScreen.append("4");
				break;
			case R.id.btn_5:
				tvScreen.append("5");
				break;
			case R.id.btn_6:
				tvScreen.append("6");
				break;
			case R.id.btn_7:
				tvScreen.append("7");
				break;
			case R.id.btn_8:
				tvScreen.append("8");
				break;
			case R.id.btn_9:
				tvScreen.append("9");
				break;
			case R.id.btn_Add:
				val1=Double.parseDouble(tvScreen.getText().toString());
				Items.add(new Item(val1, Types.Num));
				checkAndCompute();
				Items.add(new Item(0, Types.Add));
				tvScreen.setText("");
				break;
			case R.id.btn_Sub:
				val1=Double.parseDouble(tvScreen.getText().toString());
				Items.add(new Item(val1, Types.Num));
				checkAndCompute();
				Items.add(new Item(0, Types.Sub));
				tvScreen.setText("");
				break;
			case R.id.btn_X:
				val1=Double.parseDouble(tvScreen.getText().toString());
				Items.add(new Item(val1, Types.Num));
				checkAndCompute();
				Items.add(new Item(0, Types.X));
				tvScreen.setText("");
				break;
			case R.id.btn_Div:			
				val1=Double.parseDouble(tvScreen.getText().toString());
				Items.add(new Item(val1, Types.Num));
				checkAndCompute();
				Items.add(new Item(0, Types.Div));
				tvScreen.setText("");
				break;
			case R.id.btn_Result:
				val2=Double.parseDouble(tvScreen.getText().toString());
				Items.add(new Item(val2, Types.Num));
				checkAndCompute();
				tvScreen.setText(Items.get(0).value+"");
				Items.clear();
				break;
			case R.id.btn_Clear:
				tvScreen.setText("");
				Items.clear();
				break;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tvScreen.setText("输入错误，请清除后重新输入！");
			Items.clear();
		}

	}

	public void checkAndCompute() {
		if (Items.size() >= 3) {
			double a = Items.get(0).value;
			double b = Items.get(2).value;
			int opt = Items.get(1).type;
			Items.clear();
			switch (opt) {
			case Types.Add:
				Items.add(new Item(a+b, Types.Num));
				break;
			case Types.Sub:
				Items.add(new Item(a-b, Types.Num));
				break;
			case Types.X:
				Items.add(new Item(a*b, Types.Num));
				break;
			case Types.Div:
				Items.add(new Item(a/b, Types.Num));
				break;
			}
		}
	}
}
