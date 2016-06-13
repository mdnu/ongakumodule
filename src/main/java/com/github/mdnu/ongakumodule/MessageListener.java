package com.github.mdnu.ongakumodule;

import sx.blah.discord.api.*;
import sx.blah.discord.util.*;
import sx.blah.discord.handle.impl.events.*;
import sx.blah.discord.handle.obj.*;

public class MessageListener {
	private IMessage message;
	private String messageContent;
	private IChannel channel;
	
	@EventSubscriber
	public void onMessage(MessageReceivedEvent event) throws HTTP429Exception, DiscordException, MissingPermissionsException  {
		message = event.getMessage();
		messageContent = message.getContent();
		channel = message.getChannel();
		
		if (messageContent.charAt(0) == '!') {
			messageContent = messageContent.trim().replaceAll("!", "");
			switch(messageContent) {
				case ("a") : {
					sendMessage("a!");
					break;
				}
				case ("b") : {
					sendMessage("b!");
					break;
				}
				case ("c") : {
					sendMessage("c!");
					break;
				}
				default : break;
			}
		}
	}
	
	
	/**
	 * Helper method for sending messages.
	 */
	public void sendMessage(String message, IChannel channel) {
		try {
			new MessageBuilder(MusicModule.client).withChannel(channel).withContent(message).build();
		} catch (HTTP429Exception | DiscordException | MissingPermissionsException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message) {
		sendMessage(message, this.channel);
	}
}
