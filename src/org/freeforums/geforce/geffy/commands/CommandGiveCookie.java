package org.freeforums.geforce.geffy.commands;

import org.freeforums.geforce.geffy.main.Reference;
import org.freeforums.geforce.geffy.utils.Utils;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class CommandGiveCookie implements ICommand<MessageEvent, PrivateMessageEvent> {

	public void exeChan(MessageEvent event, String[] args) throws Exception {
		if(args.length == 0){
			event.respond("Here's a " + Reference.cookieTypes[Utils.getRandomNumber(Reference.cookieTypes.length - 1)] + " cookie for you!"); 
		}else if(args.length == 1){
			Utils.sendMessage(event, args[0] + ", here's a " + Reference.cookieTypes[Utils.getRandomNumber(Reference.cookieTypes.length - 1)] + " cookie for you!");
		}
	}

	public void exePrivate(PrivateMessageEvent event, String[] args) throws Exception {
		if(args.length == 0){
			event.respond("Here's a " + Reference.cookieTypes[Utils.getRandomNumber(Reference.cookieTypes.length - 1)] + " cookie for you!"); 
		}
	}

	public String[] getAliases() {
		return new String[]{"givecookie"};
	}

}
