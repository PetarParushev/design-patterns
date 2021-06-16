package Factory;

import Mediator.MessageMediator;

public class ChatUserFactory extends UserFactory {

	@Override
	public User CreateUser(MessageMediator mediator, String type, String userName) {
		switch (type) {
			 case "User":
				return new ChatUser(mediator,userName);
				 
			 case "Bot":
				return ChatBot.createBot(mediator,userName);
				 
			 default: 
				throw new NullPointerException("No such factory type.");
		 }
	}
}
