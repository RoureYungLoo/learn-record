package config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//public class CommonImportSelector implements ImportSelector {
//    @Override
//    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        return new String[]{"config.CommonConfig"}; // 指定配置类注册BEan
//    }
//}


public class CommonImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> imports = new ArrayList<>();
        InputStream inputStream = CommonImportSelector.class.getClassLoader().getResourceAsStream("common.imports");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                imports.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException();
//            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException();
//                e.printStackTrace();
            }
        }

        // return new String[]{"config.CommonConfig"}; // 指定配置类注册BEan
        return imports.toArray(new String[0]); // 指定配置类注册BEan
    }
}