package org.freeforums.geforce.geffy.misc;

import java.util.HashMap;
import java.util.Iterator;

import org.freeforums.geforce.geffy.main.Bot;
import org.freeforums.geforce.geffy.utils.Utils;
import org.pircbotx.hooks.events.MessageEvent;

public class MessageHandler {
	
	public static HashMap<String, String[]> messagesToRespondTo = new HashMap<String, String[]>();
	public static String[] newCommitToMessages = new String[]{"Oh look, a new commit!", "G17HU8-C0MM17 missile incoming, starboard side! Direct hit!",
			"G17HU8-C0MM17 missile incoming, port side! Direct hit!", "G17HU8-C0MM17 missile incoming, starboard side! Launching R3V3R7 flare!",
			"G17HU8-C0MM17 missile incoming, port side! Launching R3V3R7 flare!"};
	
	public static void tryRespondingToMessage(MessageEvent<Bot> event) {
		Iterator<String> keys = messagesToRespondTo.keySet().iterator();
		
		while(keys.hasNext()){
			String key = keys.next();
			if(event.getMessage().toLowerCase().contains(key)){
				String[] messages = messagesToRespondTo.get(key);
	
				String message = messages[Utils.getRandomNumber(messages.length, true)];
				Utils.sendMessage(event, message);
			}	
		}
	}	

}
