package org.jboss.errai.ui.demo.client.shared;

import org.jboss.errai.databinding.client.api.Bindable;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
@Bindable
public class Profile
{
   private String username;
   private String email;

   public String getUsername()
   {
      return username;
   }

   public void setUsername(String username)
   {
      this.username = username;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }
}
