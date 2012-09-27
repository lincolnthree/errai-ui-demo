package org.jboss.errai.ui.demo.client.shared;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.marshalling.client.api.annotations.MapsTo;

@Portable
public class Response {

	private String text;

	public Response(@MapsTo("text") String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
