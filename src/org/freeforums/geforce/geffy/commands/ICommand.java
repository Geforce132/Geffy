package org.freeforums.geforce.geffy.commands;

import org.pircbotx.hooks.Event;

/**
 * All of Geffy's commands must implement this.
 * 
 * Copied from Maunz's code. Thanks Vauff. :)
 */
public interface ICommand<M extends Event, P extends Event> {
	 
	public void exeChan(M event, String[] args) throws Exception;
	
	public void exePrivate(P event, String[] args) throws Exception;
		
	public String[] getAliases();
}