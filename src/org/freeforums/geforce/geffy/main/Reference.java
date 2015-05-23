package org.freeforums.geforce.geffy.main;

import org.freeforums.geforce.geffy.commands.*;

public class Reference {
	
	//Important variables and arrays.
	public static final String commandPrefix = "#";
	
	public static ICommand[] commands = new ICommand[]{new CommandHelp(), new CommandRank(), new CommandGiveCookie()};
    public static String[] joinedChannels = new String[]{"#Geforce", "#GeforceMods", "#bl4ckscor3", "#Razz"};	
    public static String[] ignoredUsers = new String[]{"GeffyBot", "bl4ckb0t", "Maunz", "Corobot", "Cadbury"};	
    
    //Other things.
	public static String[] cookieTypes = new String[]{"chocolate chip", "peanut butter", "raisin", "oatmeal", "white fudge", "sugar", "frosted", "Oreo"};

}
