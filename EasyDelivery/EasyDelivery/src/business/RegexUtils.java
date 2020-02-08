/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.event.InputEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Abc
 */
public class RegexUtils {

    public static boolean isEmpty(String value, String message) {

        if (value != null && value.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, message);
            return true;
        } else {
            return false;
        }

    }

    public static boolean isInteger(String value, String message) {
        String intRegex = "^\\d+";
        if (value.matches(intRegex)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }

    }

    public static boolean isDouble(String value, String message) {

        String doubleRegex = "^\\d+(\\.\\d+)?";
        if (value.matches(doubleRegex)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }
    }

    public static boolean isValidDate(String value, String message) {

        String dateRegex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
        if (value.matches(dateRegex)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }
    }

    public static boolean isValidTime(String value, String message) {

        String timeRegex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        if (value.matches(timeRegex)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }
    }

    public static boolean isAlphaNumeric(String value, String message) {

        String alphaNumerixExp = "[a-zA-Z0-9]+";
        if (value.matches(alphaNumerixExp)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, message);
            return false;

        }
    }
    
    public static boolean isText(String fieldName, String value, boolean singleSpaceOnly) {
        if(singleSpaceOnly){
            if(value!=null){
               int count = StringUtils.countMatches(value.trim(), " "); 
               if(count>1){
                   JOptionPane.showMessageDialog(null, String.format("Too many spaces in %s", fieldName));
                   return false;
               }
            } 
        }
        
        return isText(value, String.format("Not a valid %s", fieldName));
    }

    public static boolean isText(String value, String message) {
        if(value!=null && !value.trim().isEmpty()){
            String textRegex = "[a-zA-Z]+";
            if (value.matches(textRegex)) {
                return true;
            } 
        }
        JOptionPane.showMessageDialog(null, message);
        return false;
    }

    public static boolean isValidYear(String value, String message) {
        if(value!=null && !value.trim().isEmpty()){
            String textRegex = "^\\d{4}$";
            if (value.matches(textRegex)) {
                return true;
            } 
        }
        JOptionPane.showMessageDialog(null, message);
        return false;
    }

    public static boolean isValidZipCode(String value) {
        
        if(value!=null && !value.trim().isEmpty()){
            String zipCodePattern = "\\d{5}(-\\d{4})?";
            if (value.matches(zipCodePattern)) {
                return true;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Not a valid zip code");
        return false;
    }

    public static boolean isvalidEmail(String mail, String msg) {
        
        if(mail!=null && !mail.trim().isEmpty()){
            String email = "^[\\w]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
            Pattern pattern = Pattern.compile(email);
            Matcher matcher = pattern.matcher(mail);
            if (matcher.matches()) {
                return true;
            } 
        }
            
        JOptionPane.showMessageDialog(null, msg);
        return false;
    }

    public static boolean isValidContactNumner(String value) {
        
        if(value!=null && !value.trim().isEmpty()){
            String contactNumPattern = "\\d{10}";
            if (value.matches(contactNumPattern)) {
                return true;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Not a valid contact number");
        return false;
    }

    public void checkPassword(String password, JProgressBar progressBar, JLabel lbl) {
        KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_BACKSPACE, InputEvent.META_MASK);
        progressBar.setVisible(true);
        progressBar.setStringPainted(true);
        int strengthPercentage = 0;
        String[] check = {".*[a-z]+.*", // lower
            ".*[A-Z]+.*", // upper
            ".*[\\d]+.*", // digits
            ".*[@#$%]+.*" // symbols
    };
        if (password.equals(key)) {
            progressBar.setValue(0);
            lbl.setText("Weaker");
        }
        if (password.matches(check[0])) {
            strengthPercentage += 25;

        }
        if (password.matches(check[1])) {
            strengthPercentage += 25;

        }
        if (password.matches(check[2])) {
            strengthPercentage += 25;

        }
        if (password.matches(check[3])) {
            strengthPercentage += 25;

        }
        if (strengthPercentage > 20) {
            progressBar.setBackground(Color.red);

            progressBar.setValue(strengthPercentage);
            lbl.setText("");
        }
        if (password.length() == 0) {
            strengthPercentage += 0;
            progressBar.setValue(0);
            lbl.setText("");
        }
        if (strengthPercentage == 0) {
            progressBar.setBackground(Color.red);
            progressBar.setValue(0);
            lbl.setText("");
        }
        if (strengthPercentage > 0) {
            progressBar.setValue(25);
            progressBar.setBackground(Color.red);
            lbl.setText("Weak");
        }
        if (strengthPercentage > 26) {
            progressBar.setBackground(Color.yellow);

            progressBar.setValue(strengthPercentage);
            lbl.setText("Better");
        }
        if (strengthPercentage > 51) {
            progressBar.setBackground(Color.orange);

            progressBar.setValue(strengthPercentage);
            lbl.setText("Strong");
        }
        if (strengthPercentage > 76) {
            progressBar.setBackground(Color.green);

            progressBar.setValue(strengthPercentage);
            lbl.setText("Very Strong");
        }
    }
}
