package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.kim.employee.dao.EmployeeDao;

public class CreateEmployeeID {
	private CreateEmployeeID() {
	}
	
	static public String createEmpID(String enter_dt)
	{
		String id=null;
		EmployeeDao dao=EmployeeDao.getInstance();
		int count=dao.getEmpCount();
		String strCount=null;
		String dateStr=null;
		if(enter_dt!=null)
		{
			dateStr=enter_dt.replaceAll("-", "");
		}
		else
		{
			Calendar cal =Calendar.getInstance();
			SimpleDateFormat sdf =new SimpleDateFormat("YYYYMMdd");
			Timestamp date = new Timestamp(cal.getTime().getTime());	
			dateStr=sdf.format(date);
		}
	
		if((count/1000)>0)
			strCount=String.valueOf(count);
		else if((count/100)>0)
			strCount="0"+String.valueOf(count);
		else if((count/10)>0)
			strCount="00"+String.valueOf(count);
		else
			strCount="000"+String.valueOf(count);	
		id=dateStr+strCount;
		return id;
	}

	
	
}
