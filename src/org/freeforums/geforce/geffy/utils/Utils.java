package org.freeforums.geforce.geffy.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class Utils {
	
	//IRC methods.
	
	public static void sendMessage(MessageEvent event, String message){
		event.getChannel().send().message(message);
	}
	
	public static void sendMessage(PrivateMessageEvent event, String message){
		event.getBot().sendIRC().message(event.getUser().getNick(), message);
	}
	
	/**
	 * Returns a new array containing all the arguments in a command, without the command name itself.
	 * 
	 * E.G: "~givecookie Geforce sugar" equals: <p>
	 *      args[0] = Geforce <p>
	 *      args[1] = sugar
	 */
	public static String[] getArgsFromCommand(String command){
		String[] args = new String[(command.split(" ").length - 1)];
		
		for(int i = 1; i < command.split(" ").length; i++){
			args[i - 1] = command.split(" ")[i];
		}
		
		return args;
	}
	
	public static String arrayToString(String[] args){
		String string = "";
		
		for(int i = 0; i < args.length; i++){
			string += args[i] + ((i != (args.length - 1)) ? " " : "");
		}
		
		return string;
	}
	
	public static String[] trimArray(String[] args, int trimAmount){
		String[] array = new String[args.length - trimAmount];
		
		if(array.length == 0){ return null; }
		
		for(int i = 0; i < array.length; i++){
			array[i] = args[i];
		}
		
		return array;
	}
	
	//Helpful methods.
	
	/**
	 * Returns a random number, up to the given maximum.
	 */
	public static int getRandomNumber(int max, boolean include0){
		Random random = new Random();
		
		int i = random.nextInt(max + 1);
		return (i == 0 && !include0 ? 1 : i);
	}
	
	/**
	 * Parses a string to an Integer.
	 */
	public static int toInt(String num){
		return Integer.parseInt(num);
	}
	
	/**
	 * Does the array contain the given object?
	 */
	public static boolean arrayContains(Object[] array, Object o){
		for(int i = 0; i < array.length; i++){
			if(array[i].equals(o)){
				return true;
			}
		}
		
		return false;
	}
    
    /**
	 * Output all key / value pairs.
	 */
	public static void outputHashMap(HashMap<String, String> hashmap){
	    Collection<String> cValue = hashmap.values();
	    Collection<String> cKey = hashmap.keySet();
	    Iterator<String> itrValue = cValue.iterator();
	    Iterator<String> itrKey = cKey.iterator();
		
		while (itrValue.hasNext() && itrKey.hasNext()){
			System.out.println(itrKey.next() + ": " + itrValue.next());
		}
	}
	
	/**
	 * Returns -1 if the first version is older then the second. <p>
	 * Returns 0 if they match. <p>
	 * Returns 1 if the first version is newer then the second. <p>
	 */
	public static Integer compareVersions(String str1, String str2) {
		String[] vals1 = str1.split("\\.");
		String[] vals2 = str2.split("\\.");
		
		int i = 0;
		
		while(i < vals1.length && i < vals2.length && vals1[i].equals(vals2[i])){
			i++;
		}
		
		if(i < vals1.length && i < vals2.length){
			int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
			return Integer.signum(diff);
		}else{
			return Integer.signum(vals1.length - vals2.length);
		}
	}

}
