package com.chhaichivon.springzk.util;

import org.zkoss.zul.Messagebox;

/**
 * @author: chhai.chivon on 6/13/2018.
 */
public class MessageBoxUtil {

    private static String Warning = "Warning";
    private static String Question = "Question";
    private static  String Information = "Information";
    private static  String Error = "Error";
    private static String ConfirmDialog  = "Confirm Dialog";



    public static void showMsg(String option, String caption, String msgText) {
        if(option.compareToIgnoreCase("ERROR") == 0) {
            Messagebox.show("Error: " + msgText, caption, Messagebox.OK, Messagebox.ERROR);
        }
        else if(option.compareToIgnoreCase("VALIDATE") == 0) {
            Messagebox.show(msgText, caption, Messagebox.OK, Messagebox.EXCLAMATION);
        }
        else if(option.compareToIgnoreCase("SUCCESS") == 0) {
            Messagebox.show(msgText, caption, Messagebox.OK, Messagebox.INFORMATION);
        }
    }
}
