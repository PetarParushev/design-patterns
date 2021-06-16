package Mediator;

import Factory.User;

public interface MessageMediator {
	void sendMessage(String message, User user);
	void addUser(User user);
	void removeUser(User user);
}
