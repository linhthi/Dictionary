
package folder;

import java.io.FileNotFoundException;


public class DictionaryCommandLine {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    
    public void showAllWord() {
        Dictionary myDictionary = new Dictionary();
        int count =1;
        System.out.println("No   | English \t | Vietnamese ");
        for (Word i : myDictionary.listWord) {
            System.out.println(count+ "   |"  + i.getWord_target() +"\t | " + i.getWord_explain());
            count++;
        }
    }
    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandLine();
        this.showAllWord();
    }
    public void dictionaryAdvanced() throws FileNotFoundException {
        dictionaryManagement.insertFromFile();
        dictionaryManagement.dictionaryLookup();
        this.showAllWord();
    }
}
