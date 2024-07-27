package helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class MyHelper {

	public static boolean saveImgFile(InputStream is, String path) {

		boolean f = false;

		try {

			int size = is.available();

			byte[] b = new byte[size];
			is.read(b);

			FileOutputStream fos = new FileOutputStream(path);
			fos.write(b);

			fos.close();

			f = true;

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("file not saved in pics !!!");

		}

		return f;

	}

	// pdf upload helper

	public static boolean savePdfFile(HttpServletRequest req, String path) {
		boolean success = false;
		try {

			Part part = req.getPart("cpdf");
			String pdfName = part.getSubmittedFileName();

			if (pdfName != null && !pdfName.isEmpty()) {
				String finalPAth = path + File.separator + pdfName;

				// create pdfs folder if not exist
				File f = new File(path);

				if (!f.exists()) {
					f.mkdirs();// creates directoty if not exist
				}

				part.write(finalPAth);

				success = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;

	}

}