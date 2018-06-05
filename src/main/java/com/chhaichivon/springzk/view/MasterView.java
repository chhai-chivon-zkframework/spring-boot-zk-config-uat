package com.chhaichivon.springzk.view;



import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;

/**
 * @author: Chhai Chivon on 5/25/18.
 */
public class MasterView  extends SelectorComposer<Component> {


    @Wire
    Textbox keywordBox;


    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);


        keywordBox.setValue("Hello");
    }
}
