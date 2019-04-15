package edu.hm.cs.fwp.cloudtrain.core.boundary;

import edu.hm.cs.fwp.cloudtrain.core.entity.Message;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.security.Principal;
import java.util.UUID;

/**
 * Simple {@code Boundary} that returns welcome messages.
 */
@Stateless
// @RolesAllowed("CLOUDTRAIN_USER")
public class HelloWorld {

    private static final String WELCOME_MESSAGE_TEMPLATE = "Dear \"%s\", welcome to a cloud native Java application based on MicroProfile protected by OpenID Connect!";

    @Resource
    private SessionContext sessionContext;

    public Message getHelloMessage() {
        return new Message(UUID.randomUUID(), "hello", String.format(WELCOME_MESSAGE_TEMPLATE, getAuthenticatedUserName()));
    }

    private String getAuthenticatedUserName() {
        String result = "anonymous";
        Principal principal = this.sessionContext.getCallerPrincipal();
        if (principal != null) {
            result = principal.getName();
        }
        return result;
    }
}
