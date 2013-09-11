/*
 * This is free and unencumbered software released into the public domain.
 */
package com.mycompany;

import org.apache.log4j.Logger;
import org.apache.wicket.Component;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;
import us.jts.fortress.ReviewMgr;
import us.jts.fortress.rbac.AuthZ;
import us.jts.fortress.rbac.Permission;
import us.jts.fortress.rbac.Session;
import us.jts.fortress.rbac.User;
import us.jts.fortress.util.attr.VUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.StringTokenizer;

/**
 * ...
 *
 * @author Shawn McKinney
 * @version $Rev$
 */
public class GlobalUtils
{
    private static final Logger LOG = Logger.getLogger( GlobalUtils.class.getName() );
    public static final String WINDOW_LOCATION_REPLACE_LOGIN_LOGIN_HTML = "window.location.replace(\"/login/login.html\");";

    public static Session getRbacSession( Component component )
    {
        return ( ( RbacSession ) component.getSession() ).getRbacSession();
    }

    public static List<Permission> getRbacPermissions( Component component )
    {
        return ( ( RbacSession ) component.getSession() ).getPermissions();
    }

    public static boolean isAuthorized( String roleName, HttpServletRequest servletReq )
    {
        boolean isAuthorized = false;
        if ( servletReq.isUserInRole( roleName ) )
        {
            isAuthorized = true;
        }
        return isAuthorized;
    }

    public static boolean isFound( Permission permission, Component component )
    {
        List<Permission> permissions = GlobalUtils.getRbacPermissions( component );
        return VUtil.isNotNullOrEmpty( permissions ) && permissions.contains( permission );
    }
}
