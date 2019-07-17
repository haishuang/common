package com.hs.common.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.hs.common.utils.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Dialog显示一段时间后消失
 */
public class ShowActionDialog extends Dialog {
	private Context context;
	private TextView actionTextView;
	View roost;

	public ShowActionDialog(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getContext().setTheme(R.style.toast_dialog);
		roost = View.inflate(context,R.layout.dialog_show_action, null);
		setContentView(roost);
		actionTextView = (TextView) findViewById(R.id.tv_action_text);
	}

	public void setActionText(String actiontext) {
		this.actionTextView.setText(actiontext);
	}

	@Override
	public void show() {
		super.show();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				// 定时结束
				dismiss();
			}
		}, 2000);// 设定指定的时间time,此处为2000毫秒
	}
}
