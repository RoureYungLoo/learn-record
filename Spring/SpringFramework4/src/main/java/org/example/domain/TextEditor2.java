package org.example.domain;

import org.springframework.beans.factory.annotation.Required;

public class TextEditor2 {
    private String name;
    private SpellCheck spellCheck;

    public String getName() {
        return name;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }

    @Required
    public void setSpellCheck(SpellCheck spellCheck) {
        this.spellCheck = spellCheck;
    }

    public void spellCheck(){
        spellCheck.checkSpelling();
    }
    public SpellCheck getSpellCheck() {
        return spellCheck;
    }
}
