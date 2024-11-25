package XMLLoader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class TravelerXMLParser extends XMLParser {
    Document document = null;
    List<Object[]> objects = new ArrayList<>();
    @Override
    public List<Object[]> getTagsInfo(String xmlName) {
        try {
            document = searchingFile(xmlName);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

        Element root = document.getDocumentElement();
        NodeList travelerList = root.getElementsByTagName("traveler");

        // spot 태그를 순회하면서 데이터를 추출
        for (int i = 0; i < travelerList.getLength(); i++) {
            Node travelerNode = travelerList.item(i);

            if (travelerNode.getNodeType() == Node.ELEMENT_NODE) {
                Element travelerElement = (Element) travelerNode;

                // 태그
                String name = travelerElement.getElementsByTagName("name").item(0).getTextContent();
                int age = Integer.parseInt(travelerElement.getElementsByTagName("age").item(0).getTextContent());

                Object[] spotData = {name, age};
                // Objects[] 배열로 생성하여 리스트에 추가
                objects.add(spotData);
            }
        }

        return objects;
    }
}
