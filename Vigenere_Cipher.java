/*
Christopher Serrano 
2/11/18
Project 1 - Vigenere Cipher in java
 */

public class Project_1_Code__Serrano_Christopher {
    
    public static void main(String args[]){
        
        //Key to encrypt and decrypt. Is my last name
        String key = "Serrano";
        
        //Message to be encoded/decrypted. Edit for different test cases
        String message = "llzj if o lijk fbf ec arvn djsxiaz hg wlsmvh xsi trldlsxiacvq";
        
        //What will be outputted to the user
        System.out.println("Key given: " + key + "\n");
        System.out.println("Message given: " + message + "\n");
        
        System.out.println("Encrypted message: " + encrypt(key, message));
        System.out.println("Decrypted message: " + decrypt(key, message));
        
    }
    
    //Method called to encrypt passed message with passed key
    static public String encrypt(String k, String m){
        
        //Setup variables
        String result = "";
        //Made uppercase to not confuse unicode of lower chars
        k = k.toUpperCase();
        m = m.toUpperCase();
        
        int j = 0;  //Will increment each time a char is translated (used for key)
        
        for (int i=0; i<m.length(); i++){
            
            char c = m.charAt(i);
            
            if( c < 'A' || c > 'Z'){ //Check if char is outside the alphabet
                
                //Nothing will happen if c is a non-alphabet character
                //Will simply add spaces and special chars if present
                 result+= c;
                
                
            }
            else{// 'A' = 65, 'Z' = 90
                
                result+= (char)(((c-65) + (k.charAt(j)-65)) % 26 + 65);
                j= ++j % k.length();
            }
            
        }//end of for loop
        
        return result;
    }// end of encrypt method
    
    
    //Method called to decrypt passed message with passed key
    static public String decrypt(String k, String m){
        
        //Setup variables
        String result = "";
        //Made uppercase to not confuse unicode of lower chars
        k = k.toUpperCase();
        m = m.toUpperCase();
        
        int j = 0; //Will increment each time a char is translated (used for key)
        
        for (int i=0; i<m.length(); i++){
            
            char c = m.charAt(i);
            
            if( c < 'A' || c > 'Z'){
                
                //Nothing will happen if c is a non-alphabet character
                //Will simply add spaces and special chars if present
                result+= c;
                
            }
            else{// 'A' = 65, 'Z' = 90
                
                result+= (char)(((c-65) - (k.charAt(j)-65) + 26) % 26 + 65);
                j= ++j % k.length();
            }
            
        }//end of for loop
        
        return result;
    }// end of decrypt method
    
}// end of entire class
