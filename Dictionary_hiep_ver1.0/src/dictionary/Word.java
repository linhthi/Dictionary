/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author HIEPATK
 */
public class Word {
    private String word_tagret;
    private String word_explain;
    
    /*public Word(String target,String explain){
        this.word_tagret = target;
        this.word_explain = explain;
    }
    void Word(){
    }
    */
    public void setTarget(String target){
        this.word_tagret = target;
    }
    public void setExplain(String explain){
        this.word_explain = explain;
    }
    public String getTarget(){
        return this.word_tagret;
    }
    public String getExplain(){
        return this.word_explain;
    }
    
}
