package con.lyw.entry;

import con.lyw.invocationhandler.MyInvocationHandler;
import con.lyw.service.KingFactory;
import con.lyw.service.UsbFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
  public static void main(String[] args) {
    KingFactory kingFactory = new KingFactory();
    InvocationHandler handler = new MyInvocationHandler(kingFactory);
    UsbFactory usbFactory = (UsbFactory) Proxy.newProxyInstance(kingFactory.getClass().getClassLoader(),
            kingFactory.getClass().getInterfaces(),
            handler
    );

    Float sell = usbFactory.sell();
    System.out.println(sell);
  }
}
