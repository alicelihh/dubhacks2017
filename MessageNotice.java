import javax.swing.*;
import java.net.URL;

public class MessageNotice {
    public static void main(String[] args) throws Exception {
        Object[] options = {"Yes", "Not at all"};
        int n = JOptionPane.showOptionDialog(
                    null, 
                    "Are you offended by his/her words? \n Inappropriate word(s) detected!",
                    "Inquiry",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
         if (n == 0) {
            JEditorPane editorPane = new JEditorPane();
            editorPane.setPage(new URL("http://www.google.com"));
         }   
    }
}
