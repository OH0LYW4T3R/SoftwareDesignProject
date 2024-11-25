package XMLLoader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

public class SpotXMLParser extends XMLParser {
    Document document = null;
    List<Object[]> objects = new ArrayList<>();

    public List<Object[]> getTagsInfo(String xmlName) {
        // 얘는 스팟xml 에서 오브젝트 배열 가공해서 반환
        // builder와 factory가 있는지 체크
        try {
            document = searchingFile(xmlName);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

        Element root = document.getDocumentElement();
        NodeList spotList = root.getElementsByTagName("spot");

        // spot 태그를 순회하면서 데이터를 추출
        for (int i = 0; i < spotList.getLength(); i++) {
            Node spotNode = spotList.item(i);

            if (spotNode.getNodeType() == Node.ELEMENT_NODE) {
                Element spotElement = (Element) spotNode;

                // flag, name, address 값 추출
                String provider = spotElement.getElementsByTagName("provider").item(0).getTextContent();
                String flag = spotElement.getElementsByTagName("Flag").item(0).getTextContent();
                String name = spotElement.getElementsByTagName("name").item(0).getTextContent();
                String address = spotElement.getElementsByTagName("address").item(0).getTextContent();

                Object[] spotData = {provider, flag, name, address};
                // Objects[] 배열로 생성하여 리스트에 추가
                objects.add(spotData);
            }
        }

        return objects;
    }

    // {스팟이름, 위도, 경도}, {스팟이름, 위도, 경도}, {스팟이름, 위도, 경도}, {스팟이름, 위도, 경도}

}
