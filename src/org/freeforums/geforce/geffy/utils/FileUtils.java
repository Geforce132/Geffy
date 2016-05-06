package org.freeforums.geforce.geffy.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URL;
import java.util.Scanner;

public class FileUtils {
	
	public static int getNumberOfLinesInFile(String filePath){
		try{
			InputStream in = FileUtils.class.getResourceAsStream(filePath);
			LineNumberReader lnr = new LineNumberReader(new BufferedReader(new InputStreamReader(in)));
			lnr.skip(Long.MAX_VALUE);
			return lnr.getLineNumber() + 1;
		}catch(IOException e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public static String readLineFromFile(String filePath, int line){
		InputStream in = FileUtils.class.getResourceAsStream(filePath);
		LineNumberReader lnr = new LineNumberReader(new BufferedReader(new InputStreamReader(in)));

		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(in)));
		
		for(int i = 1; i < line; i++){
			scanner.nextLine();
		}
		
		return scanner.nextLine();
	}

}
