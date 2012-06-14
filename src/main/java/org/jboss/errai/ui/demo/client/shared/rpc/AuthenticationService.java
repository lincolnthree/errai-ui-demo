package org.jboss.errai.ui.demo.client.shared.rpc;

import org.jboss.errai.bus.server.annotations.Remote;
import org.jboss.errai.ui.demo.client.shared.Profile;

@Remote
public interface AuthenticationService
{
   /**
    * Sign in the current user, using the given username / password combination.
    * 
    * @return
    */
   public Profile login(String username, String password);

   /**
    * Log out the current user. Terminating any active sessions. If the user was not logged in, this method is a no-op.
    */
   public void logout();
}