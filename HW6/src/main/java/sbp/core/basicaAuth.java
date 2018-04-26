/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbp.core;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import java.util.Optional;
/**
 *
 * @author Jeffrey

*/

public class basicaAuth implements Authenticator<BasicCredentials, User>  {

    @Override
    public Optional<User> authenticate(BasicCredentials c) throws AuthenticationException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
  


}
