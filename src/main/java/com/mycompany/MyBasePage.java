/*
 * This is free and unencumbered software released into the public domain.
 */
package com.mycompany;

import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.http.handler.RedirectRequestHandler;
import org.apache.wicket.spring.injection.annot.SpringBean;
import us.jts.fortress.AccessMgr;
import us.jts.fortress.rbac.Permission;
import us.jts.fortress.rbac.Session;
import us.jts.fortress.rbac.User;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

/**
 * Base class for MyProject.
 *
 * @author Shawn McKinney
 * @version $Rev$
 */
public abstract class MyBasePage extends WebPage
{
    @SpringBean
    private AccessMgr accessMgr;

    private static final Logger LOG = Logger.getLogger( MyBasePage.class.getName() );

    public MyBasePage()
    {
        SecureBookmarkablePageLink page1Link = new SecureBookmarkablePageLink( "page1", Page1.class, "ROLE_TEST1" );
        add( page1Link );
        SecureBookmarkablePageLink page2Link = new SecureBookmarkablePageLink( "page2", Page2.class, "ROLE_TEST1,ROLE_TEST2" );
        add( page2Link );
        SecureBookmarkablePageLink page3Link = new SecureBookmarkablePageLink( "page3", Page3.class, "ROLE_TEST1,ROLE_TEST3" );
        add( page3Link );
        final Link actionLink = new Link( "logout" )
        {
            @Override
            public void onClick()
            {
                HttpServletRequest servletReq = ( HttpServletRequest ) getRequest().getContainerRequest();
                servletReq.getSession().invalidate();
                getSession().invalidate();
                getRequestCycle().scheduleRequestHandlerAfterCurrent(new RedirectRequestHandler("/login/login.html"));
            }
        };
        add( actionLink );
        add( new Label( "footer", "This is free and unencumbered software released into the public domain." ) );
        HttpServletRequest servletReq = ( HttpServletRequest ) getRequest().getContainerRequest();
        Principal principal = servletReq.getUserPrincipal();
        boolean isLoggedIn = principal != null;
        // Is this a Java EE secured page && has the User successfully authenticated already?
        if ( isLoggedIn )
        {
            // TODO: make sure this is both necessary & thread safe:
            synchronized ( ( RbacSession ) RbacSession.get() )
            {
                if ( GlobalUtils.getRbacSession( this ) == null )
                {
                    try
                    {
                        // Create an RBAC session and attach to Wicket session:
                        Session session = accessMgr.createSession( new User( principal.getName() ), true );
                        String message = "RBAC Session successfully created for userId: " + session.getUserId();
                        ( ( RbacSession ) RbacSession.get() ).setSession( session );
                        List<Permission> permissions = accessMgr.sessionPermissions( session );
                        ( ( RbacSession ) RbacSession.get() ).setPermissions( permissions );
                        LOG.debug( message );
                    }
                    catch ( us.jts.fortress.SecurityException se )
                    {
                        String error = "caught SecurityException=" + se;
                        LOG.error( error );
                        throw new RuntimeException( error );
                    }
                }
            }
        }
        else
        {
            actionLink.setVisible( false );
        }
    }
}