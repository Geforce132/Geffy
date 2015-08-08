package org.freeforums.geforce.geffy.commands;

import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class CommandHelp implements ICommand<MessageEvent, PrivateMessageEvent> {

	public void exeChan(MessageEvent event, String[] args) throws Exception {
		if(args.length == 0){
			event.respond("Sorry, I don't have an official help command yet. You can find a temporary listing of all the commands at https://www.github.com/Geforce132/Geffy");
		}
	}

	public void exePrivate(PrivateMessageEvent event, String[] args) throws Exception {
		if(args.length == 0){
			event.respond("Sorry, I don't have an official help command yet. You can find a temporary listing of all the commands at https://www.github.com/Geforce132/Geffy");
		}
	}

	public String[] getAliases() {
		return new String[]{"help"};
	}

}
