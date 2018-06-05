package com.chhaichivon.springzk.util;

import java.util.HashMap;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Messagebox;

/**
 * @author chhai.chivon on May 29, 2018
 *
 */

public class WindowUtil {
	
	private WindowUtil(){}

    public static void newWindow(Hbox hbContent,String url, HashMap<String, String> args) {
        try {
            hbContent.getChildren().clear();
            Executions.createComponents(url, hbContent, args);
        }
        catch(Exception ex) {
            hbContent.getChildren().clear();
            Messagebox.show(ex.getMessage(), "Error in Menu", Messagebox.OK, Messagebox.ERROR);
        }
    }

    public static void removeWindow(Hbox hbContent) {
        try {
            hbContent.getChildren().clear();
            hbContent.detach();
        }
        catch(Exception ex) {
            Messagebox.show(ex.getMessage(), "Error in Menu", Messagebox.OK, Messagebox.ERROR);
        }
    }
}
