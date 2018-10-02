
package folder;


public class DictionaryCommandLine {
    public void showAllWord() {
        Dictionary myDictionary = new Dictionary();
        int count =1;
        System.out.println("No   | English \t | Vietnamese ");
        for (Word i : myDictionary.listWord) {
            System.out.println(count+ "   |"  + i.getSpelling() +"\t | " + i.getExplain());
            count++;
        }
    }
    public void dictionaryBasic() {
        DictionaryManagement dBasic = new DictionaryManagement();
        dBasic.insertFromCommandLine();
        DictionaryCommandLine dCmd = new DictionaryCommandLine();
        dCmd.showAllWord();
    }
}
