package Observer.Admin;

import Observer.Provider.Provider;
import Observer.Publisher;
import Observer.Subscriber;

// 관리자
// 관리자는 뭘 관리 해야할까? -> 사용자 관리 / 콘텐츠 관리
//
public interface Admin extends Publisher {
    //
    public void allReadProvider();
    public void addProvider(Provider provider);
    public void DeleteProvider(Provider provider);
}
