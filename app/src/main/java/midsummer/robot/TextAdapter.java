package midsummer.robot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * 项目名称：Robot
 * 类描述：
 * 创建人：77.
 * 创建时间：2016/3/5 0005 21:34
 * 修改人：77.
 * 修改时间：2016/3/5 0005 21:34
 * 修改备注：
 * QQ：951203598
 */
public class TextAdapter extends BaseAdapter
{
	private List<ListData> lists;
	private Context mContext;
	private RelativeLayout layout;
	
	public TextAdapter(List<ListData> lists, Context mContext)
	{
		this.lists = lists;
		this.mContext = mContext;
	}
	
	@Override
	public int getCount()
	{
		return lists.size();
	}
	
	@Override
	public Object getItem(int position)
	{
		return lists.get(position);
	}
	
	@Override
	public long getItemId(int position)
	{
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		LayoutInflater inflater = LayoutInflater.from(mContext);
		if (lists.get(position).getflag() == ListData.RECEIVER)
		{
			layout = (RelativeLayout) inflater.inflate(R.layout.liftitem, null);
		}
		if (lists.get(position).getflag() == ListData.SEND)
		{
			layout = (RelativeLayout) inflater.inflate(R.layout.rightitem, null);
		}
		TextView tv = (TextView) layout.findViewById(R.id.tv);
		TextView time = (TextView) layout.findViewById(R.id.time);
		tv.setText(lists.get(position).getContent());
		time.setText(lists.get(position).getTime());
		return layout;
	}
}
