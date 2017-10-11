package maskingsample;

import java.util.*;

public class MaskingSample {
    private String data = "abcd";
    
    public MaskingSample(String data){this.data = data;}

    private MaskingSample() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void append(char c){data += c;}
    public void setData(String data){this.data = data;}
    
    public String getMasked() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<data.length(); i++) {
            sb.append('*');
        }
            return sb.toString();
    }
    
    public String getString() {
        return data;
    }
    
    public static void main(String[] args) {
        MaskingSample go;
        go = new MaskingSample();
    }
    
}
