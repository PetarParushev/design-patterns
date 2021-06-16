package Factory;

import Mediator.MessageMediator;

public class ChatUser extends User {

	public ChatUser(MessageMediator med, String name) {
		super(med, name);
		med.addUser(this);
	}

	@Override
	public void send(String msg) {
        System.out.println(getName() + " says: " + msg);
        mediator.sendMessage(msg, this);
	}
	@Override
	public void receive(String msg) {
	    System.out.println(getName() + " receives:" + msg);
	}

}
