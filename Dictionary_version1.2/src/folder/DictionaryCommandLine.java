
package folder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class DictionaryCommandLine {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    
     /**
     * The method dictionary basic from version 1
     * insert the list Word form Command Line
     * This calls insertFromCommandLine method and showAllWord method of class DictionaryManagement
    */
    public void dictionaryBasic() {
        System.out.println("*************Dictionary Basic*************");
        System.out.println("");
        System.out.println("VUI LONG SU DUNG CAC LENH DUOI DAY");
        System.out.println("0: Thoat ung dung");
        System.out.println("1: Them tu vao tu dien");
        System.out.println("2: Hien thi danh sach tu");
        Scanner reader = new Scanner(System.in);
        char c = reader.next().charAt(0);

        switch (c) {
            case '0':
                System.out.println("Dang thoat");
                return;
            case '1':
                dictionaryManagement.insertFromCommandLine();  
                break;
            case '2':
                dictionaryManagement.showAllWord();
                break;    
            default:
                break;
        }
        dictionaryBasic();
    }
    /**
     * The method dictionary advanced from version 2
     * inset the list word from file
     * This calls inertFromFile method, dictionaryLookup method 
     * and showAllWord method of class DictionaryManagement
     * @throws FileNotFoundException 
     */
    public void dictionaryAdvanced() throws FileNotFoundException, IOException {
        System.out.println("************* Dictionary Advanced*************");
        System.out.println("");
        System.out.println("VUI LONG SU DUNG CAC LENH DUOI DAY");
        System.out.println("0: Thoat ung dung");
        System.out.println("1: Them tu vao tu dien bang file");
        System.out.println("2: Hien thi danh sach tu");
        System.out.println("3: Tim kiem tu");
        System.out.println("4: Tim danh sach cac tu bat dau voi xau ban nhap vao");
        
        Scanner reader = new Scanner(System.in);
        char c = reader.next().charAt(0);

        switch (c) {
            case '0':
                System.out.println("Dang thoat");
                return;
            case '1':
                dictionaryManagement.insertFromFile();
                System.out.println("Da them tu tu file!");
                break;
            case '2':
                dictionaryManagement.showAllWord();
                break;    
            case '3':
                dictionaryManagement.dictionaryLookup();
                break; 
            case '4':
                dictionaryManagement.dictionarySeacher();
            default:
                break;
        }
        System.out.println("");
        dictionaryAdvanced();
    }
          
    }
    

