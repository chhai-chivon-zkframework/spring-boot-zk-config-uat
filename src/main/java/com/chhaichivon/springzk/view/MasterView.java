package com.chhaichivon.springzk.view;



import com.chhaichivon.springzk.config.CookieManager;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

/**
 * @author: Chhai Chivon on 5/25/18.
 */
public class MasterView  extends SelectorComposer<Component> {


    @Wire
    Hbox hbContent;
    @Wire
    Tabs mainTab;
    @Wire
    Tabbox tbLeftMenu;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        if(CookieManager.getCookie(CookieManager.APP_USER_ID) != "" && CookieManager.getCookie(CookieManager.APP_USER_ID) != ""){

        }else{
	     		Executions.sendRedirect("login.zul");
        }


        Tab tab;
        for (int i=0;i<5;i++){
            tab =  new Tab();
            tab.setLabel("Label" + i);
            mainTab.onChildAdded(tab);
        }
    }

    private void onInit(){

    }




    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Listen("onClick = #tlbLogout")
    public void confirmLogout() {
        Messagebox.show("Do you want to logout ?"
                ,"Logout"
                ,Messagebox.YES | Messagebox.NO
                ,Messagebox.QUESTION
                ,new org.zkoss.zk.ui.event.EventListener() {
                    public void onEvent(Event e) {
                        if(Messagebox.ON_YES.equals(e.getName())) {
                            onLogout();
                        }
                        else if(Messagebox.ON_NO.equals(e.getName())) { }
                    }
                }
        );
    }
    private void onLogout(){

    }
}
