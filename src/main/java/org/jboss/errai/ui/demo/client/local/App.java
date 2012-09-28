/*
 * Copyright 2009 JBoss, a division of Red Hat Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.errai.ui.demo.client.local;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.demo.client.shared.Message;
import org.jboss.errai.ui.demo.client.shared.Profile;
import org.jboss.errai.ui.demo.client.shared.Response2;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Main application entry point.
 */
@Templated("Mockup.html#template")
@EntryPoint
public class App extends Composite {

	@Inject
	@DataField
	private Button send;

	@Inject
	@DataField
	private TextBox message;

	@Inject
	@DataField
	private Label response;

	@Inject
	private Event<Message> toServer;

	@Inject
	@DataField
	private TextBox name;

	@Inject
	@DataField
	private TextBox email;

	@Inject
	@AutoBound
	private DataBinder<Profile> profile;

	@PostConstruct
	public void setup() {
		RootPanel.get("rootPanel").add(this);
	}

	@EventHandler("send")
	public void handleSendMessage(ClickEvent event) {
		send.setEnabled(false);
		toServer.fire(new Message(message.getText()));
	}

	public void handleResponse(@Observes Response2 msg) {
		response.setText(msg.getName());
		send.setEnabled(true);
	}

}
