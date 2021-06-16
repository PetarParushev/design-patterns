package Mediator;

import java.util.ArrayList;
import java.util.List;

import Factory.ChatBot;
import Factory.ChatUserFactory;
import Factory.User;

public class ChatRoomMediator implements MessageMediator {

	private List<User> users;
	private ChatBot bot;
	
    public ChatRoomMediator() {
        this.users = new ArrayList<>();
    }
	
	@Override
	public void sendMessage(String message, User user) {
		
		if (!users.contains(user)) {
			System.out.println("You are not in the room. You need to join in order to send messages.");
			return;
		}
		
        if(message.equals("addBot") && bot==null) {
        	ChatUserFactory factory = new ChatUserFactory();
        	bot = (ChatBot) factory.CreateUser(this, "Bot", "CensorshipBot");
        }
        
		if(message.contains("cat" )&& bot!=null) {
			this.removeUser(user);
			bot.send(user.getName() + " was blocked! (Forbidden word used)");
			return;
		}
		
        for (User chatMember : this.users) {
            if (chatMember != user) {
            	chatMember.receive(message);
            }
        }
	}

	@Override
	public void addUser(User user) {
        this.users.add(user);
		System.out.println(user.getName() + " joined the chat.");
	}

	@Override
	public void removeUser(User user) {
		this.users.remove(user);
	}
}
