package org.freeforums.geforce.geffy.misc;

import java.io.File;
import java.util.Random;

import org.freeforums.geforce.geffy.main.Bot;
import org.freeforums.geforce.geffy.utils.FileUtils;
import org.freeforums.geforce.geffy.utils.Utils;
import org.pircbotx.hooks.events.MessageEvent;

public class MessageHandler {
	
	private static final String[] messagesToRespondTo = new String[]{"new commit to master"};

	public static void tryRespondingToMessage(MessageEvent<Bot> event) {
		for(String s : messagesToRespondTo){
			if(event.getMessage().toLowerCase().contains(s)){
				File file = new File("messages/" + s + ".txt");
				int lines = FileUtils.getNumberOfLinesInFile("messages/" + s + ".txt");
				Utils.sendMessage(event, FileUtils.readLineFromFile("messages/" + s + ".txt", new Random().nextInt(lines + 1)));
				break;
			}
		}
	}

}
