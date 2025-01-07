package com.design_pattern.creational.prototype_pattern.four.doc;

import java.io.Serializable;

public interface OfficialDocument extends Cloneable {
    OfficialDocument clone();

    public void display();
}
