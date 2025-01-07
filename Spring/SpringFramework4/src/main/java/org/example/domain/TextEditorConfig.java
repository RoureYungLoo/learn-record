package org.example.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Spliterator;

@Configuration
@Import(BeanConfig.class)
public class TextEditorConfig {

    @Bean
    public TextEditor textEditor() {
        return new TextEditor(spellCheck()); // 注入依赖关系,直接调用返回Bean的方法即可
    }

    @Bean
    public SpellCheck spellCheck() {
        return new SpellCheck();
    }
}
