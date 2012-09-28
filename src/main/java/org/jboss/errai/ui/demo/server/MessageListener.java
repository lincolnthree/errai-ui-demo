package org.jboss.errai.ui.demo.server;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.errai.ui.demo.client.shared.Message;
import org.jboss.errai.ui.demo.client.shared.Response2;

public class MessageListener {

	@Inject
	private Event<Response2> toClient;

	public void handleMessage(@Observes Message message) {
		toClient.fire(new Response2("The server got your message, ["
				+ message.getText() + "] at [" + System.currentTimeMillis()
				+ "]"));
	}
}
