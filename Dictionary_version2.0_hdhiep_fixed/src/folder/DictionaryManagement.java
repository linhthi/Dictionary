package folder;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
            System.out.print(i+1 + "\nWord is: ");
            _word.setWord_target(scan.nextLine());
            System.out.print("Mean is: ");
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
        
        Scanner scan = new Scanner(new File("dictionaries.txt"));
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
        String a ;
        System.out.println("Ban hay nhap tu muon tra:");
        Scanner scan = new Scanner(System.in);
        a= scan.nextLine();
        for (Word i: myDictionary.listWord) {
            if (i.getWord_target().equals(a)) {
                System.out.println(a + " means :" + i.getWord_explain());
            }
        }
        
    }
    /**
     * The method puts all the word 
     * of current dictionary in File "DictionaryNow.txt"
     * @throws java.io.FileNotFoundException
     */
    public void dictionaryExportToFile() throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream("dictionaries.txt");
        BufferedOutputStream bout = new BufferedOutputStream(fout);
        
        for (Word i: myDictionary.listWord) {
            String line = i.getWord_target()+"\t" + i.getWord_explain();
                bout.write(line.getBytes());
                bout.write(System.lineSeparator().getBytes()) ;
            
        }
        bout.close();
    }
     //Ham them mot tu tu command line
    public void insertWord() {
        System.out.println("Nhap tu can them vao theo dinh dang word_target \\t word_explain:");
        Scanner scan = new Scanner(System.in);
        String stringWord = scan.nextLine();
        Scanner s = new Scanner(stringWord).useDelimiter("s*\ts*");
                String spelling = s.next();
                String explain = s.next();
        Word newWord = new Word(spelling, explain);
        myDictionary.listWord.add(newWord);
    }
    //Ham xoa mot tu tu command line
    public void removeWord(String Word_target) {
        for (Word i: myDictionary.listWord) {
            if (i.getWord_target().equals(Word_target)) {
                myDictionary.listWord.remove(i);
            }
        }
    }
    //Ham sua du lieu tu command line
    public void fixWord() {
        
    }
}
