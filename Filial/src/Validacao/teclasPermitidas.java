
package Validacao;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author rodrigo
 */
//permite que seja inserido nos campos apenas letras minusculas - "a-z".
public class teclasPermitidas extends PlainDocument {
    
    @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException{
      super.insertString(offset, str.replaceAll("[^a-z]", ""), attr); 
    }
    
       public void replace(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException{
      super.insertString(offset, str.replaceAll("[^a-z]", ""), attr); 
    }
    
}
