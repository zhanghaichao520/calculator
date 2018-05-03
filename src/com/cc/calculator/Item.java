package com.cc.calculator;

import android.R.integer;
import android.R.transition;

public class Item {
	public Item(double value,int type) {
		this.type=type;
		this.value=value;
	}
	public double value = 0;
	public int type = 0;
}
