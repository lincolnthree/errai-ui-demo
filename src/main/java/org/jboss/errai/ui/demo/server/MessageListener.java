package org.jboss.errai.ui.demo.server;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.errai.ui.demo.client.shared.AddFragment;
import org.jboss.errai.ui.demo.client.shared.Fragment;

public class MessageListener {

	@Inject
	private Event<AddFragment> toClient;

	public void handleMessage(@Observes Fragment message) {
		System.out.println("Got message: " + message);
		toClient.fire(new AddFragment(message.getName(), message.getText()));
	}
}
