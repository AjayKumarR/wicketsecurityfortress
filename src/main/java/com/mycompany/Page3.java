/*
 * This is free and unencumbered software released into the public domain.
 */
package com.mycompany;


import org.apache.wicket.markup.html.basic.Label;


public class Page3 extends MyBasePage
{
    public Page3()
    {
        add(new Label("label3", "This is Page3"));
    }
}
