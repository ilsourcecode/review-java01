package con.lyw.invocationhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

  private Object object;

  public MyInvocationHandler(Object object) {
    this.object = object;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("目标方法执行了，添加事务！");
    Float invoke = (Float) method.invoke(object, args);
    System.out.println("目标方法执行结束了！提交事务！在原有价格上加了3元！");
    return invoke + 3.0f;
  }
}
