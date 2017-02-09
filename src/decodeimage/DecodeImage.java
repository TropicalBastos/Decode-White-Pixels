package decodeimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/*Hackthissite programming challenge 2 solution: 
decoding the ASCII codes of white pixels of an image*/
public class DecodeImage {

    public static void main(String[] args) {
        try{
        BufferedImage bi = ImageIO.read(new File(
                "Specify Image Path Here"));
        
        String result="";
        boolean firstGone=false;
        int xCount=0;
        int lastFound=0;
        
        for(int y=0;y<bi.getHeight();y++){
            for(int x=0;x<bi.getWidth();x++){
                String clr = Integer.toHexString(bi.getRGB(x, y));
                if(clr.equals("ffffffff")){
                    if(!firstGone){
                        char c = (char) x;
                        result+=""+c;
                        lastFound=x;
                        firstGone=true;
                    }else{
                        int sub = xCount-lastFound;
                        char c = (char) sub;
                        result+=""+c;
                        lastFound=xCount;
                    }
                }
                xCount++;
            }
        }
        
        System.out.println(result);
        System.out.println(morseToString(result));
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static String morseToString(String str){
        
        String result="";
        List<String> list = new ArrayList<String>();
        String[] morse = new String[39];
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                if(morse[count]==null){
                    morse[count]="";
                }
               morse[count]+=""+str.charAt(i);
            }else{
                count++;
            }
        }
        
        for(String x : morse){
            if(x!=null){
                list.add(x);
            }
        }
        
        for(String x: list){
                switch(x){
                    
                    case ".-": result+="a";
                    break;
                    case "-...": result+="b";
                    break;
                    case "-.-.": result+="c";
                    break;
                    case "-..": result+="d";
                    break;
                    case ".": result+="e";
                    break;
                    case "..-.": result+="f";
                    break;
                    case "--.": result+="g";
                    break;
                    case "....": result+="h";
                    break;
                    case "..": result+="i";
                    break;
                    case ".---": result+="j";
                    break;
                    case "-.-": result+="k";
                    break;
                    case ".-..": result+="l";
                    break;
                    case "--": result+="m";
                    break;
                    case "-.": result+="n";
                    break;
                    case "---": result+="o";
                    break;
                    case ".--.": result+="p";
                    break;
                    case "--.-": result+="q";
                    break;
                    case "...": result+="s";
                    break;
                    case "-": result+="t";
                    break;
                    case "..-": result+="u";
                    break;
                    case "...-": result+="v";
                    break;
                    case ".--": result+="w";
                    break;
                    case "-..-": result+="x";
                    break;
                    case "-.--": result+="y";
                    break;
                    case "--..": result+="z";
                    break;
                    case "-----": result+="0";
                    break;
                    case ".----": result+="1";
                    break;
                    case "..---": result+="2";
                    break;
                     case "...--": result+="3";
                    break;
                    case "....-": result+="4";
                    break;
                    case ".....": result+="5";
                    break;
                    case "-....": result+="6";
                    break;
                    case "--...": result+="7";
                    break;
                    case "---..": result+="8";
                    break;
                    case "----.": result+="9";
                    break;
                    case ".-.-.-": result+=".";
                    break;
                    case "--..--": result+=",";
                    break;
                    case "..--..": result+="?";
                    break;
                    
                }
        }
        
        return result;
    }
    
}
