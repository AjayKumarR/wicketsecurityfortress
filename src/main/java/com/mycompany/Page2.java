/*
 * This is free and unencumbered software released into the public domain.
 */
package com.mycompany;


import org.apache.wicket.markup.html.basic.Label;


public class Page2 extends MyBasePage
{
    public Page2()
    {
        add(new Label("label2", "This is Page2"));
    }
}
