package org.freeforums.geforce.geffy.utils;

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
	 * E.G: "#givecookie Geforce sugar" equals: <p>
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
	
	//Helpful methods.
	
	/**
	 * Returns a random number, up to the given maximum.
	 */
	public static int getRandomNumber(int max){
		Random random = new Random();
		return random.nextInt(max);
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

}
