package org.jboss.errai.ui.demo.client.shared;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.marshalling.client.api.annotations.MapsTo;

@Portable
public class Response2 {

	private String name;

	public Response2(@MapsTo("name") String text) {
		this.name = text;
	}

	public String getName() {
		return name;
	}
}
