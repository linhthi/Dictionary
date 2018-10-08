
package folder;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        DictionaryCommandLine newCommandLine = new DictionaryCommandLine();
        newCommandLine.dictionaryBasic();
        newCommandLine.dictionaryAdvanced();
    }
}
