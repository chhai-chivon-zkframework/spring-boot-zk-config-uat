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





/*

        String url = "http://www.google.com";
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();

        // Build a list of browsers to try, in this order.
        String[] browsers = {"epiphany", "firefox", "mozilla", "konqueror",
                "netscape","opera","links","lynx"};



        try{

            if (os.indexOf( "win" ) >= 0) {

                // this doesn't support showing urls in the form of "page.html#nameLink"
                //rt.exec( "rundll32 url.dll,FileProtocolHandler " + url);
                //work
                Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome https://stackoverflow.com"});
                //Runtime.getRuntime().exec(new String[]{"cmd", "/c","start firefox https://stackoverflow.com"});


            } else if (os.indexOf( "mac" ) >= 0) {

                rt.exec( "open " + url);

            } else if (os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0) {

                // Do a best guess on unix until we get a platform independent way

                // Build a command string which looks like "browser1 "url" || browser2 "url" ||..."
                StringBuffer cmd = new StringBuffer();
                for (int i=0; i<browsers.length; i++)
                    cmd.append( (i==0  ? "" : " || " ) + browsers[i] +" \"" + url + "\" ");

                rt.exec(new String[] { "sh", "-c", cmd.toString() });

            } else {
                return;
            }
        }catch (Exception e){
            return;
        }
        return;
*/

    }
    public void closeWin() throws SQLException {
        Clients.evalJavaScript("javascript:window.open('','_self','');window.close();");
    }
}
