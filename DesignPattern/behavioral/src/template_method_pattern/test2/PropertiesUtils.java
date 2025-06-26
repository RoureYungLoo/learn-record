package template_method_pattern.test2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
  private static Properties properties;

  static {
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    InputStream in = classLoader.getResourceAsStream("account.properties");
    properties = new Properties();
    try {
      properties.load(in);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static String getProperty(String key) {
    return properties.getProperty(key);
  }
}
