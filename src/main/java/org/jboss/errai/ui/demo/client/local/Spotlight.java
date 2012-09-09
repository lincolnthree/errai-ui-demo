package org.jboss.errai.ui.demo.client.local;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

/*
 * This bean must be marked dependent because we do not directly @Inject it anywhere in the application.
 */
@Dependent
@Templated("App.html#spotlight")
public class Spotlight extends Composite
{
   @DataField
   private HeadingElement title = DOM.createElement("h2").cast();

   @DataField
   private ParagraphElement content = DOM.createElement("p").cast();

   @Inject
   @DataField
   private Button button;
   
   @PostConstruct
   public final void init()
   {
      button.addClickHandler(new ClickHandler() {
         @Override
         public void onClick(ClickEvent event)
         {
            Spotlight.this.removeFromParent();
         }
      });
   }

   public Button getControl()
   {
      return button;
   }

   public void setTitle(String text)
   {
      title.setInnerText(text);
   }

   public void setContent(String text)
   {
      content.setInnerText(text);
   }

}
