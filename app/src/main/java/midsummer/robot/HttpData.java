package midsummer.robot;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 项目名称：Robot
 * 类描述：
 * 创建人：77.
 * 创建时间：2016/3/5 0005 21:23
 * 修改人：77.
 * 修改时间：2016/3/5 0005 21:23
 * 修改备注：
 * QQ：951203598
 */
public class HttpData extends AsyncTask<String, Void, String>
{
	private HttpClient mHttpClient;
	private HttpGet mHttpGet;
	private HttpResponse mHttpResponse;
	private HttpEntity mHttpEntity;
	private InputStream in;
	private HttpGetDataListener listener;
	
	private String url;
	
	public HttpData(String url, HttpGetDataListener listener)
	{
		this.url = url;
		this.listener = listener;
	}
	
	@Override
	protected String doInBackground(String... params)
	{
		try
		{
			mHttpClient = new DefaultHttpClient();
			mHttpGet = new HttpGet(url);
			mHttpResponse = mHttpClient.execute(mHttpGet);
			mHttpEntity = mHttpResponse.getEntity();
			in = mHttpEntity.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = br.readLine()) != null)
			{
				sb.append(line);
			}
			return sb.toString();
			
		} catch (Exception e)
		{
			
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(String s)
	{
		listener.getDataUrl(s);
		super.onPostExecute(s);
	}
}