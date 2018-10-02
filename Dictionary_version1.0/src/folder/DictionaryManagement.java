package folder;

import java.util.Scanner;

public class DictionaryManagement {
 
    public void insertFromCommandLine() {
        Dictionary myDictionary = new Dictionary();
        Scanner scan = new Scanner(System.in);
        int numberOfWord;
        System.out.println("Nhap so tu:");
        numberOfWord = Integer.parseInt(scan.nextLine());
        
        for (int i=0; i<numberOfWord; i++) {
            Word _word = new Word();
            _word.setSpelling(scan.nextLine());
            _word.setExplain(scan.nextLine());
            myDictionary.listWord.add(_word);
        }
    }
}
