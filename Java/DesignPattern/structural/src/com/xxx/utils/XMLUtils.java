package com.xxx.utils;

import com.xxx.structural.adapter_pattern.two.OperationAdapter;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class XMLUtils {
    public static Object gerBean() {
        Object o = null;
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newDefaultInstance();
        try {
            /* 解析文档 */
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document document = builder.parse(new File("structural\\src\\config.xml"));
            NodeList nodeList = document.getElementsByTagName("adapterType");
            Node factoryNode = nodeList.item(0).getFirstChild();
            String className = "com.xxx.structural.adapter_pattern.two." + factoryNode.getNodeValue();

            /* 利用反射 */
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor();
            o = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    /**
     * @param args OS or FileName
     * @return os.* or image.*
     */
    public static Object gerBean(String args) {
        Object o = null;
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newDefaultInstance();
        try {
            /* 解析配置文件 */
//            DocumentBuilder builder = dFactory.newDocumentBuilder();
//            Document document = builder.parse(new File("structural\\src\\config.xml"));
//            NodeList nodeList = document.getElementsByTagName(args);
//            Node node = nodeList.item(0).getFirstChild();


            Map<String, String> osMap = new HashMap<>();
            osMap.put("Windows 11", "WindowsImpl");

            Map<String, String> imgMap = new HashMap<>();
            imgMap.put("jpg", "JPGImage");
            imgMap.put("bmp", "BMPImage");
            imgMap.put("png", "PNGImage");
            imgMap.put("gif", "GIFImage");

            String basePackage = "com.xxx.structural.bridge_pattern.three.";
            String osName = System.getProperty("os.name");

            String className = null;
            String suffix = null;
            switch (args) {
                case "os":
                    className = basePackage + args + "." + osMap.get(osName);
                    break;
                case "image":
                    className = "";
                    break;
                default:
                    int index = args.lastIndexOf(".");
                    System.out.println(index);
                    suffix = args.substring(index + 1, args.length());
                    System.out.println(suffix);
                    className = basePackage + "image." + imgMap.get(suffix);


            }

            System.out.println(className);
            /* 利用反射 */
            Class<?> clazz = Class.forName(className);
            Constructor<?> constructor = clazz.getConstructor();
            o = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
