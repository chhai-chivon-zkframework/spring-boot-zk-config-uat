package com.chhaichivon.springzk.view;

import com.chhaichivon.springzk.config.CookieManager;
import com.chhaichivon.springzk.util.MessageBoxUtil;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import java.sql.SQLException;

/**
 * @author: Chhai Chivon on 5/26/18.
 */
public class LoginView extends SelectorComposer<Component> {

    @Wire
    Window winLogin;

    @Wire
    Textbox txtLoginID;

    @Wire
    Textbox txtPassword;

    @Wire
    Button btnLogin;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        onClear();
    }
    private void onClear(){
        txtLoginID.setValue("");
        txtPassword.setValue("");
    }
    @Listen("onClick = #btnLogin")
    public void onLogin() throws InterruptedException, SQLException {
        String[] parValue = new String[3];
        try {
            String uName  = txtLoginID.getText().trim();
            String uPass  = txtPassword.getText().trim();
            //check database
            if (uName.trim() == "") {
                MessageBoxUtil.showMsg("ERROR", "Login", "Username is empty");
            }
            else if (uPass.trim() == "") {
                MessageBoxUtil.showMsg("ERROR", "Login", "Password is empty");
            }
            else {
                CookieManager.setCookie(CookieManager.APP_USER_ID,uName);
                CookieManager.setCookie(CookieManager.APP_USER_PWD,uPass);
                //MessageUtil.showMsg(MessageUtil.SUCCESS, "Login", "Invalid User ID or Password");
                Executions.sendRedirect("/");
            }
        }
        catch(Exception ex) {
            MessageBoxUtil.showMsg("ERROR", "Login", "Login Error. " + ex.getMessage());
        }
    }
    public void closeWin() throws SQLException {
        Clients.evalJavaScript("javascript:window.open('','_self','');window.close();");
    }
}
