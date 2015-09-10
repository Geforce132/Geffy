package org.freeforums.geforce.geffy.commands;

import org.freeforums.geforce.geffy.utils.Utils;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

@SuppressWarnings("rawtypes")
public class CommandRate implements ICommand<MessageEvent, PrivateMessageEvent> {

	public void exeChan(MessageEvent event, String[] args) throws Exception {		
		int rateScale = 5;
						
		try{
			rateScale = Integer.parseInt(args[args.length - 1]);
			event.respond("I rate " + Utils.arrayToString(Utils.trimArray(args, 1)) + " a " + Utils.getRandomNumber(rateScale, false) + " out of " + rateScale + ".");
		}catch(NumberFormatException e){
			event.respond("I rate " + Utils.arrayToString(args) + " a " + Utils.getRandomNumber(5, false) + " out of 5.");
		}
	}

	public void exePrivate(PrivateMessageEvent event, String[] args) throws Exception {
		int rateScale = 5;
						
		try{
			rateScale = Integer.parseInt(args[args.length - 1]);
			event.respond("I rate " + Utils.arrayToString(Utils.trimArray(args, 1)) + " a " + Utils.getRandomNumber(rateScale, false) + " out of " + rateScale + ".");
		}catch(NumberFormatException e){
			event.respond("I rate " + Utils.arrayToString(args) + " a " + Utils.getRandomNumber(5, false) + " out of 5.");
		}
	}

	public String[] getAliases() {
		return new String[]{"rate"};
	}

	
}
