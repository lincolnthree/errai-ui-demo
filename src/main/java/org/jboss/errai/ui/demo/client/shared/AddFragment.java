package org.jboss.errai.ui.demo.client.shared;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.jboss.errai.marshalling.client.api.annotations.MapsTo;

@Bindable
@Portable
public class AddFragment {

	private String name;
	private String text;

	public AddFragment() {
	}

	public AddFragment(@MapsTo("name") String name, @MapsTo("text") String text) {
		this.name = name;
		this.text = text;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setText(String text) {
		this.text = text;
	}
}
