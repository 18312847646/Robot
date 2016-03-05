package midsummer.robot;

/**
 * 项目名称：Robot
 * 类描述：
 * 创建人：77.
 * 创建时间：2016/3/5 0005 21:20
 * 修改人：77.
 * 修改时间：2016/3/5 0005 21:20
 * 修改备注：
 * QQ：951203598
 */
public class ListData
{
	public static final int SEND = 1;
	public static final int RECEIVER = 2;
	private String content;
	private int flag;
	private String time;
	
	public ListData(String content, int flag, String time)
	{
		setContent(content);
		setFlag(flag);
		setTime(time);
	}
	
	public void setFlag(int flag)
	{
		this.flag = flag;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
	
	public int getflag()
	{
		return flag;
	}
	
	public String getTime()
	{
		return time;
	}
	
	public void setTime(String time)
	{
		this.time = time;
	}
}
