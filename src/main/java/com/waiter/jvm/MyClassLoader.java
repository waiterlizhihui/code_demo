package com.waiter.jvm;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @ClassName MyClassLoader
 * @Description 实现自定义的类加载器
 * @Author lizhihui
 * @Date 2019/8/15 16:40
 * @Version 1.0
 */
public class MyClassLoader extends ClassLoader {
    private String classPath;

    public MyClassLoader() {

    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = this.getClassBytes(name);
        if (classBytes == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classBytes, 0, classBytes.length);
        }

//        File file = getClassFile(name);
//        try {
//            byte[] bytes = getClassBytes(file);
//            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
//            return c;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return super.findClass(name);
    }

    private File getClassFile(String name) {
        File file = new File("C:/Users/Administrator/Desktop/Person.class");
        return file;
    }

    private byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }

        fis.close();
        return baos.toByteArray();
    }

    private byte[] getClassBytes(String className) {
        String path = this.classPath + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try (InputStream inputStream = new FileInputStream(path)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num = 0;
            while ((num = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, num);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        System.out.println("当前的类加载器:" + loader);
//        System.out.println("Ext类加载器:" + loader.getParent());
//        System.out.println("Bootstrap类加载器:" + loader.getParent().getParent());

        MyClassLoader myClassLoader = new MyClassLoader("C:/Users/Administrator/Desktop/");
        Class<?> clazz = Class.forName("com.waiter.jvm.Person", true, myClassLoader);
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());
    }
}
