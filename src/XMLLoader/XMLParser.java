package XMLLoader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

// 싱글톤 패턴 사용
public abstract class XMLParser {
    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;

//    public int countTag(String filename, String tag) {
//        // searchingfile -> 있는지 없는지 판별
//        // 없으면 -> -1
//        // 있으면 --> tag 태그 찾았어
//        // 태그가 몇개 있는지 반환
//    }

    public abstract List<Objects[]> getTagsInfo();

    public boolean searchingFile(String filename) throws ParserConfigurationException {
        createSingleton();
        String directory = "src/xml/" + filename;

        try {
            Document document = builder.parse(directory);
        } catch (IOException e) {
            System.out.println(e);
            return false;
        } catch (SAXException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    private static void createSingleton() throws ParserConfigurationException {
        if(factory == null && builder == null) {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
        }
    }


}
