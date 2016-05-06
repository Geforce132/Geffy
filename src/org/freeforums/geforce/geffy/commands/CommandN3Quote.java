package org.freeforums.geforce.geffy.commands;

import org.freeforums.geforce.geffy.utils.FileUtils;
import org.freeforums.geforce.geffy.utils.Utils;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class CommandN3Quote implements ICommand<MessageEvent, PrivateMessageEvent> {
	
	private final String quotesFilePath = "/commands/n3quote/quotes.txt";
	
	public void exeChan(MessageEvent event, String[] args) throws Exception {	
        if(args.length > 0) {
        	event.respond("This command doesn't use any parameters!");
        	return;
        }
        
		int numberOfResponses = FileUtils.getNumberOfLinesInFile(quotesFilePath);

		Utils.sendMessage(event, FileUtils.readLineFromFile(quotesFilePath, Utils.getRandomNumber(numberOfResponses, true)));
	}

	public void exePrivate(PrivateMessageEvent event, String[] args) throws Exception {
		if(args.length > 0) {
        	event.respond("This command doesn't use any parameters!");
        	return;
        }
		
		int numberOfResponses = FileUtils.getNumberOfLinesInFile(quotesFilePath);

		Utils.sendMessage(event, FileUtils.readLineFromFile(quotesFilePath, Utils.getRandomNumber(numberOfResponses, true)));
	}

	public String[] getAliases() {
		return new String[]{"n3quote"};
	}

	
}
