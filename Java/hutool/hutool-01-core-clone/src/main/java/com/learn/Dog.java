package com.learn;

import cn.hutool.core.clone.CloneSupport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog extends CloneSupport<Dog> { //泛型克隆类 class CloneSupport<T>
    private String name;
    private String category;
}
