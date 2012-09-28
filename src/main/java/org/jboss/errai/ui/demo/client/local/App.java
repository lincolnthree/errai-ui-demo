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
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.databinding.client.api.InitialState;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.demo.client.shared.AddFragment;
import org.jboss.errai.ui.demo.client.shared.Fragment;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Main application entry point.
 */
@EntryPoint
@Templated("Mockup.html#template")
public class App extends Composite {

	@Inject
	private Event<Fragment> toServer;

	@PostConstruct
	public void setup() {
		RootPanel.get("rootPanel").add(this);
	}

	@Inject
	@Bound
	@DataField
	private TextBox name;

	@Inject
	@Bound
	@DataField
	private TextArea text;

	@Inject
	@DataField
	private Button submit;

	@DataField("fragments")
	private HTMLPanel fragments = new HTMLPanel("p", "");

	@Inject
	private Instance<FragmentSpan> fragmentSpans;

	@Inject
	@AutoBound
	private DataBinder<Fragment> msg;

	@EventHandler("submit")
	@SuppressWarnings("unused")
	private void handleSend(ClickEvent event) {
		toServer.fire(new Fragment(msg.getModel().getName(), msg.getModel()
				.getText()));
		msg.setModel(new Fragment(), InitialState.FROM_MODEL);
	}

	public void handleResponse(@Observes AddFragment response) {
		fragments.add(fragmentSpans.get().setFragment(
				new Fragment(response.getName(), response.getText())));
	}
}
