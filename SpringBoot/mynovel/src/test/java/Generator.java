import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Generator {
    public static final String USERNAME = System.getenv().get("USER");

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_PATH = "/src/main/java";
    public static final String RESOURCE_PATH = "/src/main/resources";
    public static final String BASE_PACKAGE = "com.randolflu.mynovel";

    private static final String DATABASE_IP = "192.168.42.133";
    private static final String DATABASE_PORT = "3306";
    private static final String DATABASE_NAME = "novel";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "mysql123456";

    public static void main(String[] args) {
        genCode("user_info");
    }

    private static void genCode(String tables) {
        FastAutoGenerator.create(
                        String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai",
                                DATABASE_IP, DATABASE_PORT, DATABASE_NAME), DATABASE_USERNAME, DATABASE_PASSWORD
                ).globalConfig(builder -> {
                    builder.author(USERNAME)
                            .fileOverride()
                            .fileOverride()
                            .commentDate("yyyy/MM/dd")
                            .outputDir(PROJECT_PATH + JAVA_PATH);
                })
                .packageConfig(builder ->
                        builder.parent(BASE_PACKAGE)
                                .entity("dao.entity")
                                .service("service")
                                .serviceImpl("service.impl")
                                .mapper("dao.mapper")
                                .controller("controller.front")
                                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, PROJECT_PATH + RESOURCE_PATH + "/mapper")))
                .templateConfig(builder -> builder.disable(TemplateType.SERVICE)
                        .disable(TemplateType.SERVICEIMPL)
                        .disable(TemplateType.CONTROLLER))
                .strategyConfig(builder -> builder.addInclude(
                                getTables(tables))
                        .controllerBuilder().enableRestStyle().serviceBuilder().formatServiceFileName("%sService")
                )
                .execute();

    }

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
