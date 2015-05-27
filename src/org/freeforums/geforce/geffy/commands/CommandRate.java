package org.freeforums.geforce.geffy.commands;

import org.freeforums.geforce.geffy.utils.Utils;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class CommandRate implements ICommand<MessageEvent, PrivateMessageEvent> {

	public void exeChan(MessageEvent event, String[] args) throws Exception {		
		if(args.length == 1){ 
			event.respond("I rate " + args[0] + " a " + Utils.getRandomNumber(5, false) + " out of 5.");
		}else if(args.length == 2){
			event.respond("I rate " + args[0] + " a " + Utils.getRandomNumber(Utils.toInt(args[1]), false) + " out of " + Utils.toInt(args[1]));
		}
	}

	public void exePrivate(PrivateMessageEvent event, String[] args) throws Exception {
		if(args.length == 1){ 
			event.respond("I rate " + args[0] + " a " + Utils.getRandomNumber(5, false) + " out of 5.");
		}else if(args.length == 2){
			event.respond("I rate " + args[0] + " a " + Utils.getRandomNumber(Utils.toInt(args[1]), false) + " out of " + Utils.toInt(args[1]));
		}
	}

	public String[] getAliases() {
		return new String[]{"rate"};
	}

	
}
