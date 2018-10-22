
package folder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        DictionaryCommandLine newCommandLine = new DictionaryCommandLine();
        char c;
        do {
        System.out.println("*********Dictionary Command Line**********");
        System.out.println("");
        System.out.println("Thuc hien theo cac lenh sau");
        System.out.println("0: Thoat chuong trinh");
        System.out.println("1: Phien ban CommandLine co ban, danh sach tu do ban nhap");
        System.out.println("2: Phien ban CommandLine nang cao, lay du lieu tu file");
        
        Scanner reader = new Scanner(System.in);
        c = reader.next().charAt(0);
        
        switch (c) {
            case '0':
                System.out.println("Dang thoat ung dung");
                break;
            case '1':
                newCommandLine.dictionaryBasic();
                break;
            case '2':
                newCommandLine.dictionaryAdvanced();
                break;    
            default:
                break;
        }
      } while (c!='0');
        
    }
}
