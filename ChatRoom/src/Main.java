import Factory.ChatUserFactory;
import Factory.User;
import Mediator.ChatRoomMediator;
import Mediator.MessageMediator;

public class Main {
	
	// The task is implemented with Mediator, Singleton (ChatBot.java) and Factory.

	public static void main(String[] args) throws Exception {
		
		MessageMediator chatroom = new ChatRoomMediator();
		ChatUserFactory userFactory = new ChatUserFactory();
		
		User user1 = userFactory.CreateUser(chatroom, "User", "Foncho");
		User user2 = userFactory.CreateUser(chatroom, "User", "Longo");
		User user3 = userFactory.CreateUser(chatroom, "User", "Mongo");
		

		user1.send("What are we doing tonight ??");
		user3.send("No clue :/");
		user2.send("Have you seen my cat ?.");
		user1.send("addBot");
		user3.send("Nvm.. the cat was found!");
		user3.send("KEKW.");
	}
}
