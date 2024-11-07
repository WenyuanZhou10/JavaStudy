package ProxyDemo.dynamicProxy.JDKProxy;

public class SmsServiceImpl implements SmsService{

    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

    @Override
    public String refresh(String message) {
        return "--refreshing--";
    }
}
