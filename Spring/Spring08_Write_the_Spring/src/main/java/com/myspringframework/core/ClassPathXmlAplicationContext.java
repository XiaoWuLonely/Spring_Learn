package com.myspringframework.core;

import org.apache.commons.beanutils.ConvertUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlAplicationContext implements ApplicationContext {
    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlAplicationContext.class);
    private Map<String, Object> singletionObject = new HashMap<>();

    /**
     * 解析myspring的配置文件,然后初始化所有的Bean对象。
     *
     * @param configLocation
     **/
    public ClassPathXmlAplicationContext(String configLocation) {
        try {
            //解析myspring.xml文件,然后实例化Bean,将Bean存放到singLetonObjects集合当中。
            //dom4j解析xml文件对象
            SAXReader reader = new SAXReader();
            //获取输入流，指向配置文件
            InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            //读文件
            Document document = reader.read(resourceAsStream);
            //获取所有bean标签
            List<Node> nodes = document.selectNodes("//bean");
            System.out.println("进行第一次遍历：传入Map对象");
            nodes.forEach(node -> {
                try {
                    //向下转型使用Element结构更加丰富的方法
                    Element beanElt = (Element) node;
                    //获取id属性
                    String id = beanElt.attributeValue("id");
                    //获取class属性
                    String className = beanElt.attributeValue("class");
                    logger.info("id = " + id);
                    logger.info("className = " + className);
                    //通过反射机制创建对象，放到Map中，提前曝光
                    Class<?> aClass = Class.forName(className);
                    //获取无参数构造方法
                    Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
                    //调用无参数构造方法实例化Bean
                    Object bean = declaredConstructor.newInstance();
                    //将Bean曝光,加入Map
                    singletionObject.put(id, bean);
                    //记录日志
                    logger.info(singletionObject.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            System.out.println("进行第二次遍历：获取property");
            //再次遍历bean标签，目的是给Bean赋值
            nodes.forEach(node -> {
                try {
                    Element beanElt = (Element) node;
                    String id = beanElt.attributeValue("id");
                    String className = beanElt.attributeValue("class");
                    Class<?> aClass = Class.forName(className);
                    //获取bean标签所有属性，比如property
                    List<Element> propertys = beanElt.elements("property");
                    propertys.forEach(property -> {
                        try {
                            //获取属性名
                            String propertyName = property.attributeValue("name");
                            logger.info("propertyName = " + propertyName);
                            //获取属性类型
                            Field field = aClass.getDeclaredField(propertyName);
                            //获得Set方法名字
                            String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                            //获取Set方法,动态根据方法名+类型获得
                            Method setMethod = aClass.getDeclaredMethod(setMethodName, field.getType());
                            //获取具体的值
                            String value = property.attributeValue("value");
                            String ref = property.attributeValue("ref");
                            if (value != null) {
                                //简单类型
                                //此处利用了commons-beanutils工具做输入类型转换成目标类型
                                Object convertedValue = ConvertUtils.convert(value, field.getType());
                                //调用Set方法
                                setMethod.invoke(singletionObject.get(id), convertedValue);
                            }
                            if (ref != null) {
                                //复杂类型
                                //调用Set方法
                                setMethod.invoke(singletionObject.get(id), singletionObject.get(ref));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanName) {
        return singletionObject.get(beanName);
    }
}
