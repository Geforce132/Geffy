package org.freeforums.geforce.geffy.utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

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

}
