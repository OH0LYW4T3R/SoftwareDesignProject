package XMLLoader;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProviderXMLParser extends XMLParser {
    List<Objects[]> objects = new ArrayList<>();
    @Override
    public List<Objects[]> getTagsInfo() {
        try {
            searchingFile("provider.xml");
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
