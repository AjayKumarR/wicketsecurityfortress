/*
 * This is free and unencumbered software released into the public domain.
 */
package com.mycompany;

import com.googlecode.wicket.jquery.ui.form.button.IndicatingAjaxButton;
import us.jts.fortress.rbac.Permission;

import javax.servlet.http.HttpServletRequest;

/**
 * ...
 *
 * @author Shawn McKinney
 * @version $Rev$
 */
public class SecureIndicatingAjaxButton extends IndicatingAjaxButton
{
    public SecureIndicatingAjaxButton( String id, String objectName, String opName )
    {
        super( id );
        if(!GlobalUtils.isFound( new Permission(objectName, opName), this ))
            setVisible( false );
    }

    public SecureIndicatingAjaxButton( String id, String roleName )
    {
        super( id );
        HttpServletRequest servletReq = ( HttpServletRequest ) getRequest().getContainerRequest();
        if( ! GlobalUtils.isAuthorized( roleName, servletReq ) )
            setVisible( false );
    }
}