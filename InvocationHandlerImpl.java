import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationHandlerImpl implements InvocationHandler {

    private Object target;

    InvocationHandlerImpl() {

    }

    InvocationHandlerImpl(Object target) {
        setTarget(target);
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        debug(method.getName());
        return method.invoke(target, args);
    }

    public void debug(String msg) {
        System.out.println("[Debug]:" + target.getClass().getCanonicalName() + "执行了" + msg + "方法!");
    }
}