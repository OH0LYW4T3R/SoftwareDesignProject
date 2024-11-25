package XMLLoader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class ProviderXMLParser extends XMLParser {
    Document document = null;
    List<Object[]> objects = new ArrayList<>();
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
        NodeList spotList = root.getElementsByTagName("Provider");

        // spot 태그를 순회하면서 데이터를 추출
        for (int i = 0; i < spotList.getLength(); i++) {
            Node spotNode = spotList.item(i);

            if (spotNode.getNodeType() == Node.ELEMENT_NODE) {
                Element providerElement = (Element) spotNode;

                // 각 태그 값 가져오기
                String name = providerElement.getElementsByTagName("name").item(0).getTextContent();
                int age = Integer.parseInt(providerElement.getElementsByTagName("age").item(0).getTextContent());
                String email = providerElement.getElementsByTagName("email").item(0).getTextContent();

                // Object[] 배열로 생성하여 리스트에 추가
                Object[] providerData = {name, age, email};
                objects.add(providerData);
            }
        }

        return objects;
    }
}
