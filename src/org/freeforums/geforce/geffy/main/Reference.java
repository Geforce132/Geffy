package org.freeforums.geforce.geffy.main;

import org.freeforums.geforce.geffy.commands.CommandGiveCookie;
import org.freeforums.geforce.geffy.commands.CommandHelp;
import org.freeforums.geforce.geffy.commands.CommandRate;
import org.freeforums.geforce.geffy.commands.ICommand;

public class Reference {
	
	//Important variables and arrays.
	public static final String commandPrefix = "~";
	
	public static ICommand[] commands = new ICommand[]{new CommandHelp(), new CommandRate(), new CommandGiveCookie()};
    public static String[] joinedChannels = new String[]{"#GeforceMods"/*, "#GeforceMods", "#bl4ckscor3", "#Razz"*/};	
    public static String[] ignoredUsers = new String[]{"GeffyBot", "Geffy"};	
    
    //Other things.
	public static String[] cookieTypes = new String[]{"chocolate chip", "peanut butter", "raisin", "oatmeal", "white fudge", "sugar", "frosted", "Oreo"};
	public static String scVersion = "v1.8.0"; //TODO: Change this with every SecurityCraft update
}
