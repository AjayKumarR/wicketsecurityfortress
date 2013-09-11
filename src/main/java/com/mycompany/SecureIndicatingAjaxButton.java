/*
 * This is free and unencumbered software released into the public domain.
 */
package com.mycompany;

import com.googlecode.wicket.jquery.ui.form.button.IndicatingAjaxButton;
import org.apache.log4j.Logger;
import org.apache.wicket.Component;
import org.apache.wicket.spring.injection.annot.SpringBean;
import us.jts.fortress.AccessMgr;
import us.jts.fortress.rbac.Permission;
import us.jts.fortress.util.attr.VUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * ...
 *
 * @author Shawn McKinney
 * @version $Rev$
 */
public class SecureIndicatingAjaxButton extends IndicatingAjaxButton
{
    @SpringBean
    AccessMgr accessMgr;

    private static final Logger LOG = Logger.getLogger(SecureIndicatingAjaxButton.class.getName());

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