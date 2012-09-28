package org.jboss.errai.ui.demo.client.shared;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.marshalling.client.api.annotations.MapsTo;

@Portable
public class Message {

	private String name;

	public Message(@MapsTo("name") String text) {
		this.name = text;
	}

	public String getText() {
		return name;
	}
}
