
package folder;

public class Word {
    private String spelling;
    private String explain;

    public Word(String spelling, String explain) {
        this.spelling = spelling;
        this.explain = explain;
    }

    public Word() {
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getExplain() {
        return explain;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }
    
    
    
    
    
}
