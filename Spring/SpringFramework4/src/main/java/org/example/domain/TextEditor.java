package org.example.domain;

import javax.annotation.Resource;

public class TextEditor {
//    @Resource(name = "spellCheck")
    private SpellCheck spellCheck;

    /* 构造函数 */

    public TextEditor(SpellCheck spellCheck) {
        System.out.println("TextEditor constructor with parameter spellCheck");
        this.spellCheck = spellCheck;
    }

    public TextEditor() {
    }

    public void spellCheck() {
        spellCheck.checkSpelling();
    }

    public void setSpellCheck(SpellCheck spellCheck) {
        System.out.println("setter: setSpellCheck()");
        this.spellCheck = spellCheck;
    }
}
