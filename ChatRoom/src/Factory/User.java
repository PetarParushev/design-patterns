package Factory;

import Mediator.MessageMediator;

public abstract class User {

    protected MessageMediator mediator;
    private String name;

    public User(MessageMediator med, String name) {
        this.mediator = med;
        this.setName(name);
    }

    public abstract void send(String msg);

    public abstract void receive(String msg);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
