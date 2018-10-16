
package folder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class DictionaryCommandLine {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    
    /**
     * The method use show all the word in dictionary
     */
    public void showAllWord() {
        Dictionary myDictionary = new Dictionary();
        int count = 1;
        System.out.println("No   | English \t | Vietnamese ");
        for (Word i : myDictionary.listWord) {
            System.out.println(count+ "   |"  + i.getWord_target() +"\t | " + i.getWord_explain());
            count++;
        }
    }
     /**
     * The method dictionary basic from version 1
     * insert the list Word form Command Line
     * This calls insertFromCommandLine method and showAllWord method of class DictionaryManagement
    */
    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandLine();
        this.showAllWord();
    }
    /**
     * The method dictionary advanced from version 2
     * inset the list word from file
     * This calls inertFromFile method, dictionaryLookup method 
     * and showAllWord method of class DictionaryManagement
     * @throws FileNotFoundException 
     */
    public void dictionaryAdvanced() throws FileNotFoundException, IOException {
        dictionaryManagement.insertFromFile();
        dictionaryManagement.dictionaryLookup();
        this.showAllWord();
        dictionaryManagement.dictionaryExportToFile();
        this.dictionarySeacher();
          
    }
    public void dictionarySeacher() {
        System.out.println("Nhap tu ban can tra: ");
        String s = new String();
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        System.out.println("Cac tu bat dau tu " + s + " la: ");
        for (Word i: Dictionary.listWord) {
            int index = i.getWord_target().indexOf(s);
            if (index == 0) {
                System.out.println(i.getWord_target() + "\t|" + i.getWord_explain());
            }
        }
    }
}
