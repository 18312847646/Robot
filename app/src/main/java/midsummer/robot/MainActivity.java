package midsummer.robot;

import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import midsummer.robot.activity.BaseActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity implements HttpGetDataListener
{
	@ViewById
	Toolbar toolbar;
	@ViewById
	ListView list;
	@ViewById
	EditText sendText;
	@ViewById
	ImageButton sendBtn;
	
	private HttpData httpData;
	private List<ListData> lists;
	private String contentstr;
	private TextAdapter adapter;
	private String[] welcome_array;
	private double currentTime, oldTime = 0;
	
	@AfterViews
	void init()
	{
		setSupportActionBar(toolbar);
		
		lists = new ArrayList<ListData>();
		adapter = new TextAdapter(lists, this);
		list.setAdapter(adapter);
		ListData listData;
		listData = new ListData(getRandomWelcomeTips(), ListData.RECEIVER, getTime());
		lists.add(listData);
	}
	
	private String getRandomWelcomeTips()
	{
		String welcome_tip = null;
		welcome_array = this.getResources().getStringArray(R.array.welcome);
		int index = (int) (Math.random() * (welcome_array.length - 1));
		welcome_tip = welcome_array[index];
		return welcome_tip;
	}
	
	private String getTime()
	{
		currentTime = System.currentTimeMillis();
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		Date curDate = new Date();
		String str = format.format(curDate);
		if (currentTime - oldTime >= 5 * 60 * 1000)
		{
			oldTime = currentTime;
			return str;
		} else
		{
			return "";
		}
	}
	
	@Click(R.id.sendBtn)
	void click()
	{
		getTime();
		contentstr = sendText.getText().toString();
		sendText.setText("");
		sendText.setText("");
		String dropk = contentstr.replace(" ", "");
		String droph = dropk.replace("\n", "");
		ListData listData;
		listData = new ListData(contentstr, ListData.SEND, getTime());
		lists.add(listData);
		adapter.notifyDataSetChanged();
		httpData = (HttpData) new HttpData("http://www.tuling123.com/openapi/api?key=984a8fa01089a85dc589cc495d3ceadd&info=" + droph, this).execute();
	}
	
	@Override
	public void getDataUrl(String data)
	{
		parseText(data);
	}
	
	public void parseText(String str)
	{
		try
		{
			JSONObject jb = new JSONObject(str);
			ListData listData;
			listData = new ListData(jb.getString("text"), ListData.RECEIVER, getTime());
			lists.add(listData);
			adapter.notifyDataSetChanged();
		} catch (JSONException e)
		{
			e.printStackTrace();
		}
	}
}
