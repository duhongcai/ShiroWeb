package com.dhc.rpc.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by DuHongcai on 2016/10/28.
 */
public class RpcFramework {
    private static final Logger logger = LoggerFactory.getLogger(RpcFramework.class);

    /**
     * 暴露服务
     *
     * @param service
     * @param port
     */
    public static void export(final Object service, int port) throws Exception {
        if (service == null)
            throw new RuntimeException("service 不能为空");
        if (port < 0 || port > 65535)
            throw new RuntimeException("port 不合法");
        //声明暴露端口号
        ServerSocket socketserver = new ServerSocket(port);
        for (; ; ) {
            try {
                final Socket socket = socketserver.accept();
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                            //TODO 黑人问号？？？？？？
                            String methodName = input.readUTF();
                            Class<?>[] paramsType = (Class<?>[]) input.readObject();
                            Object[] arsuments = (Object[]) input.readObject();

                            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                            Method method = service.getClass().getMethod(methodName, paramsType);
                            Object result = method.invoke(service, arsuments);
                            output.writeObject(result);
                            output.flush();
                            output.close();
                            input.close();
                            socket.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 远程调用
     *
     * @param interfaceClass
     * @param host
     * @param port
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) throws Exception {
        if (interfaceClass == null)
            throw new RuntimeException("interfaceClass不能为空");
        if (host == null)
            throw new RuntimeException("host不能为空");
        if (port <= 0 || port > 65535)
            throw new RuntimeException("port不合法");
        logger.info("refer方法被调用--" + interfaceClass.getName() + "from service" + host + ":" + port);
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass}, new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = new Socket(host, port);
                        try {
                            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                            try {
                                output.writeUTF(method.getName());
                                output.writeObject(method.getParameterTypes());
                                output.writeObject(args);
                                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                                try {
                                    Object result = inputStream.readObject();
                                    if (result instanceof Throwable) {
                                        throw (Throwable) result;
                                    }
                                    return result;
                                } finally {
                                    inputStream.close();
                                }
                            } finally {
                                output.close();
                            }
                        } finally {
                            socket.close();
                        }
                    }
                });
    }
}
