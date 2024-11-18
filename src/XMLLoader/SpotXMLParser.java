package XMLLoader;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpotXMLParser extends XMLParser {
    List<Objects[]> objects = new ArrayList<>();

    public List<Objects[]> getTagsInfo() {
        // 얘는 스팟xml 에서 오브젝트 배열 가공해서 반환

        // builder와 factory가 있는지 체크
        try {
            searchingFile("data.xml");
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // {스팟이름, 위도, 경도}, {스팟이름, 위도, 경도}, {스팟이름, 위도, 경도}, {스팟이름, 위도, 경도}

}
