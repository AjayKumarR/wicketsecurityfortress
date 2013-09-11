/*
 * This is free and unencumbered software released into the public domain.
 */
package com.mycompany;


import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;


public class Page1 extends MyBasePage
{

    public Page1()
    {
        add( new Page1Form( "pageForm" ) );
    }

    public class Page1Form extends Form
    {
        public Page1Form( String id )
        {
            super( id );

            add(new Label("label1", "This is in Page1"));

            add( new SecureIndicatingAjaxButton( "page1.button1", "Page1", "Button1" )
            {
                @Override
                protected void onSubmit( AjaxRequestTarget target, Form form )
                {
                    info( "Button Pressed" );
                }
                @Override
                public void onError( AjaxRequestTarget target, Form form )
                {
                    System.out.println( "deassign.onError" );
                }
                @Override
                protected void updateAjaxAttributes( AjaxRequestAttributes attributes )
                {
                    super.updateAjaxAttributes( attributes );
                    AjaxCallListener ajaxCallListener = new AjaxCallListener()
                    {
                        @Override
                        public CharSequence getFailureHandler( Component component )
                        {
                            return GlobalUtils.WINDOW_LOCATION_REPLACE_LOGIN_LOGIN_HTML;
                        }
                    };
                    attributes.getAjaxCallListeners().add( ajaxCallListener );
                }
            } );
            add( new SecureIndicatingAjaxButton( "page1.button2", "Page1", "Button2" )
            {
                @Override
                protected void onSubmit( AjaxRequestTarget target, Form form )
                {
                    info( "Button2 Pressed" );
                }
                @Override
                public void onError( AjaxRequestTarget target, Form form )
                {
                    System.out.println( "page1.button2.onError" );
                }
                @Override
                protected void updateAjaxAttributes( AjaxRequestAttributes attributes )
                {
                    super.updateAjaxAttributes( attributes );
                    AjaxCallListener ajaxCallListener = new AjaxCallListener()
                    {
                        @Override
                        public CharSequence getFailureHandler( Component component )
                        {
                            return GlobalUtils.WINDOW_LOCATION_REPLACE_LOGIN_LOGIN_HTML;
                        }
                    };
                    attributes.getAjaxCallListeners().add( ajaxCallListener );
                }
            } );
            add( new SecureIndicatingAjaxButton( "page1.button3", "Page1", "Button3" )
            {
                @Override
                protected void onSubmit( AjaxRequestTarget target, Form form )
                {
                    info( "Button3 Pressed" );
                }
                @Override
                public void onError( AjaxRequestTarget target, Form form )
                {
                    System.out.println( "page1.button3.onError" );
                }
                @Override
                protected void updateAjaxAttributes( AjaxRequestAttributes attributes )
                {
                    super.updateAjaxAttributes( attributes );
                    AjaxCallListener ajaxCallListener = new AjaxCallListener()
                    {
                        @Override
                        public CharSequence getFailureHandler( Component component )
                        {
                            return GlobalUtils.WINDOW_LOCATION_REPLACE_LOGIN_LOGIN_HTML;
                        }
                    };
                    attributes.getAjaxCallListeners().add( ajaxCallListener );
                }
            } );
        }

    }
}
