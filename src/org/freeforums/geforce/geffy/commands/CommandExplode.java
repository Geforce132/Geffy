package org.freeforums.geforce.geffy.commands;

import org.freeforums.geforce.geffy.utils.FileUtils;
import org.freeforums.geforce.geffy.utils.Utils;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class CommandExplode implements ICommand<MessageEvent, PrivateMessageEvent> {
	
	private final String responseFilePath = "/commands/explode/responses.txt";
	
	public void exeChan(MessageEvent event, String[] args) throws Exception {	
		String target = Utils.arrayToString(Utils.trimArray(args, 0));
		int numberOfResponses = FileUtils.getNumberOfLinesInFile(responseFilePath);
        String response = FileUtils.readLineFromFile(responseFilePath, Utils.getRandomNumber(numberOfResponses, true)).replaceAll("#C", target.substring(0, 1).toUpperCase() + target.substring(1)).replaceAll("#", target);
        
		event.respond(response);
	}

	public void exePrivate(PrivateMessageEvent event, String[] args) throws Exception {
		String target = Utils.arrayToString(Utils.trimArray(args, 0));
		int numberOfResponses = FileUtils.getNumberOfLinesInFile(responseFilePath);
        String response = FileUtils.readLineFromFile(responseFilePath, Utils.getRandomNumber(numberOfResponses, true)).replaceAll("#C", target.substring(0, 1).toUpperCase() + target.substring(1)).replaceAll("#", target);
        
		event.respond(response);
	}

	public String[] getAliases() {
		return new String[]{"explode"};
	}

	
}
