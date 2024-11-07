package ProxyDemo.staticProxy;

public class Main {
    public static void main(String[] args) {
        SmsProxy smsProxy = new SmsProxy(new SmsServiceImpl());
        smsProxy.send("hello world");
    }
}
