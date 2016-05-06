package org.freeforums.geforce.geffy.commands;

import org.freeforums.geforce.geffy.utils.FileUtils;
import org.freeforums.geforce.geffy.utils.Utils;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class CommandSing implements ICommand<MessageEvent, PrivateMessageEvent> {
	
	private final String linkFilePath = "/commands/sing/links.txt";
	
	public void exeChan(MessageEvent event, String[] args) throws Exception {	
		String song = Utils.arrayToString(Utils.trimArray(args, 0));
		
		for(int i = 0; i < FileUtils.getNumberOfLinesInFile(linkFilePath); i++) {
			if(FileUtils.readLineFromFile(linkFilePath, i + 1).startsWith(song)) {
				event.respond("Enjoy! " + FileUtils.readLineFromFile(linkFilePath, i + 1).replace(song + " | ", ""));
				break;
			}
		}
	}

	public void exePrivate(PrivateMessageEvent event, String[] args) throws Exception {
        String song = Utils.arrayToString(Utils.trimArray(args, 0));
		
		for(int i = 0; i < FileUtils.getNumberOfLinesInFile(linkFilePath); i++) {
			if(FileUtils.readLineFromFile(linkFilePath, i + 1).startsWith(song)) {
				event.respond("Enjoy! " + FileUtils.readLineFromFile(linkFilePath, i + 1).replace(song + " | ", ""));
				break;
			}
		}
	}

	public String[] getAliases() {
		return new String[]{"sing"};
	}

	
}
