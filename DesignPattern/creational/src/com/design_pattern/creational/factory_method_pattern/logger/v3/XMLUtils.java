package com.design_pattern.creational.factory_method_pattern.logger.v3;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Constructor;

public class XMLUtils {
    public static Object gerBean() {
        Object loggerFactory = null;
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newDefaultInstance();
        try {
            /* 解析文档 */
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document document = builder.parse(new File("D:\\CodeSpace\\learn-record\\Java\\DesignPattern\\creational\\src\\com\\design_pattern\\creational\\factory_method_pattern\\config.xml"));
            NodeList nodeList = document.getElementsByTagName("factoryType");
            Node factoryNode = nodeList.item(0).getFirstChild();
            String loggerFactoryClassName = "com.design_pattern.creational.factory_method_pattern.logger.v3."+factoryNode.getNodeValue();

            /* 利用反射 */
            Class<?> clazz = Class.forName(loggerFactoryClassName);
            Constructor<?> constructor = clazz.getConstructor();
            loggerFactory = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loggerFactory;
    }
}
