import javax.swing.*;
import java.net.URL;

public class MessageWarning {
    public static void main(String[] args) throws Exception {
        Object[] options = {"Detail Info", "Cancel"};
        int n = JOptionPane.showOptionDialog(
                    null, 
                    "You might have entered something inappropriate!",
                    "Warning",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    options,
                    options[0]);
         if (n == 0) {
            JEditorPane editorPane = new JEditorPane();
            editorPane.setPage(new URL("http://www.google.com"));
         }   
    }
}
