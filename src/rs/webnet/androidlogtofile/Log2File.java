package rs.webnet.androidlogtofile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import android.os.Environment;
import android.util.Log;

public class Log2File {
	private static File file;

	/**
	 * Init with default settings. 
	 * Log file will be named "log_file.txt" and will be stored in directory named "Log2File" in root of SDCard.
	 */
	public static void init() {
		File sdCard = Environment.getExternalStorageDirectory();
		File dir = new File(sdCard.getAbsolutePath() + "/Log2File/");
		dir.mkdirs();
		file = new File(dir, "log_file.txt");
	}
	
	/**
	 * Init Log2File with log filename.
	 * Directory would be default one "Log2File"
	 * 
	 * @param fileName file name
	 */
	public static void init(String fileName) {
		File sdCard = Environment.getExternalStorageDirectory();
		File dir = new File(sdCard.getAbsolutePath() + "/Log2File/");
		dir.mkdirs();
		file = new File(dir, fileName);
	}
	
	/**
	 * Init Log2File with log filename and directory.
	 * 
	 * @param directory path to directory
	 * @param fileName file name
	 */
	public static void init(String directory, String fileName) {
		File sdCard = Environment.getExternalStorageDirectory();
		File dir = new File(sdCard.getAbsolutePath() + "/"+directory+"/");
		dir.mkdirs();
		file = new File(dir, fileName);
	}
	
	
	/**
	 * 
	 * @param tag
	 * @param data
	 * @param file
	 */
	private static void writeStringToAFile(String tag, final String data, File file) {
		long time = System.currentTimeMillis();
		SimpleDateFormat formater = new SimpleDateFormat("HH:mm:SS  dd/MM/yyyy [Z]");

		BufferedWriter out=null;
		try {
			out = new BufferedWriter(new FileWriter(file,true));
			
			String lineToWriteToFile = formater.format(time) + " --- " + data+"\n\r";
			
			out.write(lineToWriteToFile);
			
			Log.d("Log2File",""+data);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String data){
        Log.d("Log2File",data);
		writeStringToAFile("Log2File", data, file);
	}
	public static void log(String tag, String data){
        Log.d(tag,data);
		writeStringToAFile(tag, data, file);
	}
}
