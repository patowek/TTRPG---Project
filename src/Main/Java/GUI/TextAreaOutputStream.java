package GUI;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class TextAreaOutputStream extends OutputStream {
    private JTextArea outputTxt;

    public TextAreaOutputStream(JTextArea outputTxt) {
        this.outputTxt = outputTxt;
    }

    @Override
    public void write(int b) throws IOException {
        // Append the text to the JTextArea
    	outputTxt.append(String.valueOf((char) b));
        // Auto-scroll to the bottom of the text area
    	outputTxt.setCaretPosition(outputTxt.getDocument().getLength());
    }
}