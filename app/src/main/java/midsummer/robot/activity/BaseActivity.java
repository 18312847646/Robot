package midsummer.robot.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * 项目名称：Robot
 * 类描述：
 * 创建人：77.
 * 创建时间：2016/3/5 0005 15:29
 * 修改人：77.
 * 修改时间：2016/3/5 0005 15:29
 * 修改备注：
 * QQ：951203598
 */
public class BaseActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}
}
