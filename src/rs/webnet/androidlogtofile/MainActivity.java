package rs.webnet.androidlogtofile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log2File.init();
		
		Log2File.log("test 11");
		Log2File.log("test 12");
		Log2File.log("test 13");
		Log2File.log("test 14");
		Log2File.log("test 15");
		
Log2File.init("Neki fajl.txt");
		
		Log2File.log("test 21");
		Log2File.log("test 22");
		Log2File.log("test 23");
		Log2File.log("test 24");
		Log2File.log("test 25");
		
Log2File.init("BOZA","FAJL_U_BOZA.txt");
		
		Log2File.log("test 31");
		Log2File.log("test 32");
		Log2File.log("test 33");
		Log2File.log("test 34");
		Log2File.log("test 35");
	}
	
	



}
