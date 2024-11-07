package ProxyDemo.dynamicProxy.JDKProxy;

public class Main {
    public static void main(String[] args) {
        SmsService smsService = (SmsService)JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("hello world");
        String s = smsService.refresh("1");
        System.out.println(s);
    }
}
