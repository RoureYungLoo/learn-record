package com.learn;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.Cloneable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor                             // 实现Serializable用于深克隆
public class Cat implements Cloneable<Cat> , Serializable { // 泛型克隆接口 interface Cloneable<T>
    private String name;
    private String category;

    private Address address;

    @Override
    public Cat clone() {
        try {
            return (Cat) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneRuntimeException(e);
        }
    }
}
