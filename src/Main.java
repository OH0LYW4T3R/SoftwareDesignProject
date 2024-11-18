import XMLLoader.XMLParser;

import javax.xml.parsers.ParserConfigurationException;

// 디자인패턴에서 Client 클래스 역할
// Traveler, Provider의 행동 시뮬레이션이 모두 해당 클래스 main에서 동작
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        XMLParser xmlParser = new XMLParser();
//        Provider p1 = new Provider();
//        p1.makeSpot("eat"); -> 팩토리에 접근해서 스팟 생성 -> 확장 완료!
//        SpotFactory eatSpotCreator = new EatFactory(); // 클라이언트에서 스팟 공장 생성 시뮬레이션
//        Spot eatSpot1 = eatSpotCreator.createProduct(); // 이런식으로 먹거리 스팟 생성
        try {
            System.out.println(xmlParser.searchingFile("data.xml"));
        } catch (ParserConfigurationException e) {
            System.out.println(e);
        }

    }
}


