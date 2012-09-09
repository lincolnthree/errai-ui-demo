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
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.demo.client.shared.Message;
import org.jboss.errai.ui.demo.client.shared.Profile;
import org.jboss.errai.ui.demo.client.shared.Response;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Main application entry point.
 */
/*
 * The '#template' value tells Errai UI to use the specified Element from the HTML markup file (with data-field="template") as the root of this Composite component.
 */
@Templated("#template")
@EntryPoint
public class App extends Composite
{
   /*
    * Inject any Widget with a default constructor, bind to data-field "sendMessage".
    */
   @Inject
   @DataField
   private Button sendMessage;

   /*
    * Or create it yourself, and bind to data-field "messageText".
    */
   @DataField
   private TextBox messageText = new TextBox();

   @DataField
   private HTMLPanel spotlights = new HTMLPanel("");

   /*
    * Injecting a DataBinder will bind matching the corresponding data-field Widget names, to the corresponding model fields.
    */
   @Inject
   @AutoBound
   DataBinder<Profile> profileBinder;

   @Inject
   @Bound
   @DataField
   @SuppressWarnings("unused")
   private TextBox username;

   @Inject
   @Bound
   @DataField
   @SuppressWarnings("unused")
   private TextBox email;

   /*
    * Allows us to instantiate new Spotlight instances.
    */
   @Inject
   Instance<Spotlight> spotlightInstance;

   @Inject
   private Event<Message> message;

   @PostConstruct
   public void setup()
   {
      sendMessage.addClickHandler(new ClickHandler() {
         @Override
         public void onClick(ClickEvent event)
         {
            message.fire(new Message(messageText.getText()));
         }
      });

      RootPanel.get().add(this);
   }

   public void handle(@Observes Response response)
   {
      Spotlight spotlight = spotlightInstance.get();
      String name = profileBinder.getModel().getUsername();
      String eml = profileBinder.getModel().getEmail();
      spotlight.setTitle((name == null ? "Anonymous" : name));
      spotlight.setContent((eml == null ? "" : "[ " + eml + " ]") + " " + response.getMessage());
      spotlights.add(spotlight);
   }

}
