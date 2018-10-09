package folder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryManagement {
 
    Dictionary myDictionary = new Dictionary();
    /**
     * This method use insert list word from command line
     * No parameter and return void
     */
    public void insertFromCommandLine() {
        
        Scanner scan = new Scanner(System.in);
        int numberOfWord;
        System.out.println("Nhap so tu:");
        numberOfWord = Integer.parseInt(scan.nextLine());
        
        for (int i=0; i<numberOfWord; i++) {
            Word _word = new Word();
            _word.setWord_target(scan.nextLine());
            _word.setWord_explain(scan.nextLine());
            myDictionary.listWord.add(_word);
        }
    }
    /**
     * This method use insert list Word from my file text
     * No parameter and return void
     * @throws FileNotFoundException 
     */
    public void insertFromFile() throws FileNotFoundException {
        
        Scanner scan = new Scanner(new File("dictionary_eng_vie.txt"));
        while (scan.hasNext()){
            String stringWord = scan.nextLine();
                //trong file co dinh dang: phan cach giua tu va giai nghia la dau tab
                // Su dung phương thuc useDelimiter() de dinh dang nhap vao
                Scanner s = new Scanner(stringWord).useDelimiter("s*\ts*");
            Word _word = new Word();
            _word.setWord_target(s.next());
            _word.setWord_explain(s.next());
            myDictionary.listWord.add(_word);
        }
    }
    /**
     * find the word in the dictionary and show it's mean
     * return void
     */
    public void dictionaryLookup(){
        String a = "";
        System.out.println("Ban hay nhap tu muon tra:");
        Scanner scan = new Scanner(System.in);
        a= scan.nextLine();
        for (Word i: myDictionary.listWord) {
            if (i.getWord_target().equals(a)) {
                System.out.println(a + " means :" + i.getWord_explain());
            }
        }
        
    }
}
