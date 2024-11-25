import Factory.Spot.AttractionSpot;
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
import State.HungryState;
import XMLLoader.ProviderXMLParser;
import XMLLoader.SpotXMLParser;
import XMLLoader.TravelerXMLParser;
import XMLLoader.XMLParser;

import java.util.List;
import java.util.Locale;

// 디자인패턴에서 Client 클래스 역할
// Traveler, Provider의 행동 시뮬레이션이 모두 해당 클래스 main에서 동작

//xml 구현완료, Observer Pattern 테스트 완료
public class Main {
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
                        provider.createSpot(attractionSpotFactory, String.valueOf(spot[0]), String.valueOf(spot[2]), String.valueOf(spot[3]));
                    } else if (((String) spot[1]).toUpperCase().equals(String.valueOf(SpotFlag.BASIC))) {
                        provider.createSpot(basicSpotFactory, String.valueOf(spot[0]), String.valueOf(spot[2]), String.valueOf(spot[3]));
                    } else if (((String) spot[1]).toUpperCase().equals(String.valueOf(SpotFlag.EAT))) {
                        provider.createSpot(eatSpotFactory, String.valueOf(spot[0]), String.valueOf(spot[2]), String.valueOf(spot[3]));
                    } else if (((String) spot[1]).toUpperCase().equals(String.valueOf(SpotFlag.REST))) {
                        provider.createSpot(restSpotFactory, String.valueOf(spot[0]), String.valueOf(spot[2]), String.valueOf(spot[3]));
                    }
                }
            }
        }

//        System.out.println(travelerList.get);

        for (Object[] objects : travelerList) {
            Subscriber traveler = new Traveler();
            traveler.setName((String) objects[0]);
            traveler.setAge((Integer) objects[1]);
            traveler.setState(new HungryState());

            admin.registerSubscriber(traveler);
        }

//        admin.allSubscribersRead();
     //   admin.allReadProvider();
        admin.notifySubscribers();
    }
}


