package org.jboss.errai.ui.demo.client.shared;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.jboss.errai.marshalling.client.api.annotations.MapsTo;

@Bindable
@Portable
public class Fragment {

	private String name;
	private String text;

	public Fragment() {
	}

	public Fragment(@MapsTo("name") String name, @MapsTo("text") String text) {
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

	@Override
	public String toString() {
		return "Fragment [name=" + name + ", text=" + text + "]";
	}
}
