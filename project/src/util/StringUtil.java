package util;

public class StringUtil {

	static public String[] halfString(String str,String sep)
	{
		String [] result= new String[2];
		int indexOf = str.indexOf(sep);
		try{
			
		
		result[0] = str.substring(0,indexOf);
		result[1] = str.substring(indexOf+1,str.length());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
