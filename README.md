# Geffy
Source code for my IRC bot, Geffy, on EsperNet.

This bot uses PircBotX v2.0.1 as it's IRC library.

----------
Help
----------
Command prefix: "~"

~help: Displays the help text.

~givecookie <user>: Gives that person a random type of cookie.

~rate <thing>: Rates the given thing on a scale of 1-5.
~rate <thing> <scale>: Rates the given thing from 1 to whatever number you gave it.

Geffy can also reply to any message you want him to. If you want him to respond to a certain message,
create a pull request, adding a .txt file named whatever the message you want him to respond to is, 
add the responses to the file (each on a new line), then add it to the /messages folder. It will be
merged, then deleted from the repository, so there is no spoiling. Whenever a message is posted that
contains your keyword(s), he will respond with a random response chosen from the .txt file.
