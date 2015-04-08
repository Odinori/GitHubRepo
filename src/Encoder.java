import java.util.*;
  
public class Encoder {
   
   public static void main(String[] args) {
      String message;  // Line of text entered by user.
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the message: ");
      message = sc.nextLine();
      String codeWord;
      System.out.println("Enter the code word: ");
      codeWord = sc.nextLine();
      System.out.println("(E)ncode or (D)ecode? ");
      String encode = sc.nextLine();
      if (encode.equals("E") || encode.equals("e") )
        System.out.println(encode(message, codeWord, true));
      else
        System.out.println(encode(message, codeWord, false));
         
       
    
   }
    
   static String encode(String msg, String code, boolean encode) {
       char cha;
       String message2 = Capitalize(msg);
       String message3= "";
       boolean enc = encode;
       String cw = code;
       int [] codeWord = new int[cw.length()];
       for (int ind = 0; ind < cw.length(); ind++)
            codeWord[ind] = (int)(cw.charAt(ind))- (int)('A') + 1;
       int ctr = 0;
           for (int ind = 0; ind < message2.length(); ind++) {
               cha = message2.charAt(ind);
               if (enc && Character.isLetter(cha) )
                    message3 += (char)((int)message2.charAt(ind)+codeWord[ctr]);
               else if (!enc && Character.isLetter(cha) )
                    message3 += (char)((int)message2.charAt(ind)-codeWord[ctr]);
               else
                    message3 += message2.charAt(ind);
               ctr++;   
               if (ctr >= codeWord.length) ctr = 0;
            }
            return message3;
    }
        
    
   /**
    *  Returns a capitalized copy of a string.
    *  @param str the string that is to be output in capitalized form
    */
   static String Capitalize( String str ) {
      char ch;       // One of the characters in str.
      char prevCh;   // The character that comes before ch in the string.
      int i;         // A position in str, from 0 to str.length()-1.
      String cap = "";
      prevCh = '.';  // Prime the loop with any non-letter character.
      for ( i = 0;  i < str.length();  i++ ) {
         ch = str.charAt(i);
         if ( Character.isLetter(ch) )
            cap+=( Character.toUpperCase(ch) );
         else
            cap+=( ch );
         prevCh = ch;  // prevCh for next iteration is ch.
      }
      return cap;
   }
  
} // end Encoder