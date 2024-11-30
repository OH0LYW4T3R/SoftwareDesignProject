package Main;

import Factory.Spot.Spot;
import Factory.Spot.SpotFlag;
import Factory.SpotFactory.AttractionSpotFactory;
import Factory.SpotFactory.BasicSpotFactory;
import Factory.SpotFactory.EatSpotFactory;
import Factory.SpotFactory.RestSpotFactory;
import Observer.Admin.Admin;
import Observer.Admin.BasicAdmin;
import Observer.Provider.BasicProvider;
import Observer.Provider.Provider;
import Observer.Subscriber;
import Observer.Traveler;
import RouteStrategy.RouteStrategy;
import RouteStrategy.BasicStrategy;
import State.BasicState;
import XMLLoader.ProviderXMLParser;
import XMLLoader.SpotXMLParser;
import XMLLoader.TravelerXMLParser;
import XMLLoader.XMLParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// 디자인패턴에서 Client 클래스 역할
// Traveler, Provider의 행동 시뮬레이션이 모두 해당 클래스 main에서 동작

//xml 구현완료, Observer Pattern 테스트 완료
public class Main {
    public static List<Spot> allSpotObject = new ArrayList<>();
    public static void main(String[] args) {
        // XML 파싱
        XMLParser travelerXMLParser = new TravelerXMLParser();
        XMLParser spotXMLParser = new SpotXMLParser();
        XMLParser providerXMLParser = new ProviderXMLParser();

        // 공장 생성
        RestSpotFactory restSpotFactory = new RestSpotFactory();
        EatSpotFactory eatSpotFactory = new EatSpotFactory();
        AttractionSpotFactory attractionSpotFactory = new AttractionSpotFactory();
        BasicSpotFactory basicSpotFactory = new BasicSpotFactory();

        Admin admin = new BasicAdmin();

        List<Object[]> providerList = providerXMLParser.getTagsInfo("provider.xml");
        List<Object[]> spotList = spotXMLParser.getTagsInfo("spot.xml");
        List<Object[]> travelerList = travelerXMLParser.getTagsInfo("traveler.xml");

        for (Object[] objects : providerList) {
            Provider provider = new BasicProvider(admin);
            provider.setName((String) objects[0]);
            provider.setAge((Integer) objects[1]);
            provider.setEmail((String) objects[2]);

            admin.addProvider(provider);

            for(Object[] spot : spotList) {
                if(spot[0].equals(provider.getName())) {
                    if (((String) spot[1]).toUpperCase().equals(String.valueOf(SpotFlag.ATTRACTION))) {
                        Spot aSpot = attractionSpotFactory.createSpot(String.valueOf(spot[0]), String.valueOf(spot[2]), String.valueOf(spot[3]));
                        provider.createSpot(aSpot);
                        allSpotObject.add(aSpot);
                    } else if (((String) spot[1]).toUpperCase().equals(String.valueOf(SpotFlag.BASIC))) {
                        Spot bSpot = basicSpotFactory.createSpot(String.valueOf(spot[0]), String.valueOf(spot[2]), String.valueOf(spot[3]));
                        provider.createSpot(bSpot);
                        allSpotObject.add(bSpot);
                    } else if (((String) spot[1]).toUpperCase().equals(String.valueOf(SpotFlag.EAT))) {
                        Spot eSpot = eatSpotFactory.createSpot(String.valueOf(spot[0]), String.valueOf(spot[2]), String.valueOf(spot[3]));
                        provider.createSpot(eSpot);
                        allSpotObject.add(eSpot);
                    } else if (((String) spot[1]).toUpperCase().equals(String.valueOf(SpotFlag.REST))) {
                        Spot rSpot = restSpotFactory.createSpot(String.valueOf(spot[0]), String.valueOf(spot[2]), String.valueOf(spot[3]));
                        provider.createSpot(rSpot);
                        allSpotObject.add(rSpot);
                    }
                }

            }
        }

        Subscriber testTraveler = null;

        for (Object[] objects : travelerList) {
            Subscriber traveler = new Traveler();
            traveler.setName((String) objects[0]);
            traveler.setAge((Integer) objects[1]);
            traveler.setState(BasicState.getInstance());

            admin.registerSubscriber(traveler);
            testTraveler = traveler;
        }

        admin.notifySubscribers();

        RouteStrategy shortest = new BasicStrategy();
        List<Spot> shortestRoute = shortest.excute(allSpotObject, 4);

        System.out.println("\nShortest - 원래 경로");
        for(Spot spot : shortestRoute) {
            System.out.print(spot.getStoreName() + " -> ");
        }

        // state
        System.out.println("\n\n#시뮬레이션\n");
        testTraveler.setMyRoute(shortestRoute);
        ListIterator<Spot> iterator = testTraveler.getMyRoute().listIterator();
        testTraveler.setMyRouteIterator(iterator);



        while(iterator.hasNext()) {
            Spot spot = iterator.next();
            System.out.println("#" + spot.getStoreName() + "# - "
                                   + spot.getSpotFlag().toString() + "갔다옴.");

            testTraveler.setHunger(spot);
            testTraveler.setHardness(spot);
            testTraveler.setSick(spot);

            System.out.println(testTraveler.getName() + "님의 상태 : "
                             + testTraveler.getHunger() + "-배고픔 | "
                             + testTraveler.getHardness() + "-힘듬 | "
                             + testTraveler.getSick() + "-아픔 |\n");

            testTraveler.checkHunger(); // 배고픔 수치를 검사
            testTraveler.checkHardness();
        }

        System.out.println("\nShortest - 상태에 따른 변경 경로");
        for(Spot editSpot : testTraveler.getMyRoute()) {
            System.out.print(editSpot.getStoreName() + " -> ");
        }
    }
}


