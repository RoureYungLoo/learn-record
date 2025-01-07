package com.design_pattern.creational.simple_factory_pattern.level3;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLUtil {
    /* 从配置文件中解析 chartType */
    public static String getChartType() throws Exception {
        // 创建文档对象
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = dFactory.newDocumentBuilder();
        Document doc = builder.parse(new File("config.xml"));

        // 获取包含图表类型的文本节点
        NodeList nodeList = doc.getElementsByTagName("chartType");
        Node node = nodeList.item(0).getFirstChild();
        String chartType = node.getNodeValue().trim();
        return chartType;
    }
}
