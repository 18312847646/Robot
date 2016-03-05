package midsummer.robot;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity
{
	@ViewById
	Toolbar toolbar;
	
	@AfterViews
	public void init()
	{
		setSupportActionBar(toolbar);
	}
}
