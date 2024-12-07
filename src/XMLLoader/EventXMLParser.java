package XMLLoader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventXMLParser extends XMLParser{
    Document document = null;
    List<Object[]> objects = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    public List<Object[]> getTagsInfo(String xmlName) {
        try {
            document = searchingFile(xmlName);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

        // root 요소 가져오기
        Element root = document.getDocumentElement();

        // "Provider" 태그만 가져오기
        NodeList spotList = root.getElementsByTagName("Event");

        // spot 태그를 순회하면서 데이터를 추출
        for (int i = 0; i < spotList.getLength(); i++) {
            Node spotNode = spotList.item(i);

            if (spotNode.getNodeType() == Node.ELEMENT_NODE) {
                Element providerElement = (Element) spotNode;

                // 각 태그 값 가져오기
                LocalDateTime startTime = LocalDateTime.parse(providerElement.getElementsByTagName("startTime").item(0).getTextContent(), formatter);
                LocalDateTime endTime = LocalDateTime.parse(providerElement.getElementsByTagName("endTime").item(0).getTextContent(), formatter);
                String location = providerElement.getElementsByTagName("location").item(0).getTextContent();
                String eventType = providerElement.getElementsByTagName("eventType").item(0).getTextContent(); // 보류

                // Object[] 배열로 생성하여 리스트에 추가
                Object[] providerData = {startTime, endTime, location, eventType};
                objects.add(providerData);
            }
        }

        return objects;
    }
}
