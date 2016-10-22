import javax.swing.JOptionPane;

/**
 *
 * @author dixit bhatta
 */
public class Ceaser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String text;
        int ch, factor;
        ch = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter 1 to Encrypt and 2 to Decrypt!"));
        text = JOptionPane.showInputDialog(null, "Enter plain/cipher text to encrypt?");
        factor = Integer.parseInt(JOptionPane.showInputDialog(null, "Shift characters by?"));
        text = text.toUpperCase();
        text = text.replaceAll("\\s",""); //removing spaces
        char[] ptextchars = text.toCharArray();
        switch(ch){
            case 1: 
                    for(int i=0; i<text.length();i++){
                        ptextchars[i] = encrypt(text.charAt(i),i,factor);
                    }
                    break;
            case 2:
                    for(int i=0; i<text.length();i++){
                        ptextchars[i] = decrypt(text.charAt(i),i,factor);
                    }
                    break;
            default: System.out.println("Invalid Choice!");
        }
        System.out.println(ptextchars);
    }

    private static char encrypt(char a, int i, int f) {
        int ascii = (int)a;
        ascii = ((ascii + f ) % 90);
        if(ascii < 65){//adjustment for characters bigger than Z
            ascii = ascii + 65;
        }
            //moving using 3 characters
        a = (char) ascii;
        return a;
    }

    private static char decrypt(char a, int i, int f) {
        int ascii = (int)a;
        ascii = ((ascii - f ) % 90);
        if(ascii < 65){//adjustment for characters smaller than a
            ascii = ascii + 25;
        }            
        //moving using 3 characters
        a = (char) ascii;
        return a;
    }
}
