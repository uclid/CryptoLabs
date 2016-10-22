import javax.swing.JOptionPane;

/**
 *
 * @author dixit bhatta
 */
public class Vigenere {
    public static String key = "ENIGMA"; //our key
    public static void main(String args[]){
        String text;
        int ch;
        ch = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter 1 to Encrypt and 2 to Decrypt!"));
        text = JOptionPane.showInputDialog(null, "Enter plain/cipher text to encrypt/decrypt?");
        text = text.toUpperCase();
        text = text.replaceAll("\\s",""); //removing spaces
        char[] ptextchars = text.toCharArray();  
                switch(ch){
            case 1: 
                    for(int i=0;i< text.length(); i++){
                        ptextchars[i] = encrypt(ptextchars[i],i);
                    }
                    break;
            case 2:
                    for(int i=0;i< text.length(); i++){
                        ptextchars[i] = decrypt(ptextchars[i],i);
                    }
                    break;
            default: System.out.println("Invalid Choice!");
        }
        System.out.println(ptextchars);
    }

    private static char encrypt(char c, int i) {
        int pos = (int)c % 65;
        pos = (((int)key.charAt(i%6))%65 + pos)%26;
        return (char)(pos+65);
    }

    private static char decrypt(char c, int i) {
        int pos = (int)c % 65;
        pos = (pos - (((int)key.charAt(i%6))%65))%26;
        if(pos+65 <65){ //adjustment for unstable indexes
            pos = pos + 26;
        }
        return (char)(pos+65);
    }

}
