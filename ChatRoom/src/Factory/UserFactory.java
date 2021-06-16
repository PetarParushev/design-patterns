package Factory;

import Mediator.MessageMediator;

public abstract class UserFactory {
	
	public abstract User CreateUser(MessageMediator mediator, String type, String userName);
	
}
