package org.freeforums.geforce.geffy.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class FileUtils {
	
	public static int getNumberOfLinesInFile(String filePath){
		try{
			LineNumberReader lnr = new LineNumberReader(new FileReader(filePath));
			lnr.skip(Long.MAX_VALUE);
			return lnr.getLineNumber() + 1;
		}catch(IOException e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public static String readLineFromFile(String filePath, int line){
		Scanner scanner = null;
		
		try{
			scanner = new Scanner(new File(filePath));
		}catch(IOException e){
			e.printStackTrace();
		}
		
		for(int i = 1; i < line; i++){
			scanner.nextLine();
		}
		
		return scanner.nextLine();
	}

}
