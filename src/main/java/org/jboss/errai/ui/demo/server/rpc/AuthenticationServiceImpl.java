package org.jboss.errai.ui.demo.server.rpc;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import org.jboss.errai.bus.server.annotations.Service;
import org.jboss.errai.ui.demo.client.shared.Profile;
import org.jboss.errai.ui.demo.client.shared.rpc.AuthenticationService;


@SessionScoped
@Service
public class AuthenticationServiceImpl implements Serializable, AuthenticationService
{
   private static final long serialVersionUID = -4014251052694227076L;

   @Override
   public Profile login(String username, String password)
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void logout()
   {
      // TODO Auto-generated method stub
      
   }

}