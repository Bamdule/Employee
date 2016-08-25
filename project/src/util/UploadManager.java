package util;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UploadManager {

	private UploadManager() {
	}
	
	public static MultipartRequest getMultiPartRequest(HttpServletRequest request)
	{
		String savaPath="imageUpload";
		int uploadFileSizeLimit = 20 * 1024 * 1024;
		String encType="UTF-8";
		ServletContext context =request.getServletContext();
		String uploadFilePath = context.getRealPath(savaPath);
		MultipartRequest multi=null;
		try {
				multi = new MultipartRequest(
					      request
						, uploadFilePath
						, uploadFileSizeLimit,encType
						, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return multi;
	}

}
