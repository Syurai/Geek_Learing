package springBean;

import java.util.ServiceLoader;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBean {

	public static void main(String[] args) {
		// 使用xml装配
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("file:C:/Work/eclipse-workspace-geek/week5task2/src/main/resources/bean-loader-context.xml");
        
        // 构造方法
        User userByConstructor = xmlApplicationContext.getBean("user-by-constructor", User.class);
        System.out.println(userByConstructor);
        
        // 使用静态方法装配
        User userByStaticMethod = xmlApplicationContext.getBean("user-by-static-method", User.class);
        System.out.println(userByStaticMethod);
        
        // 自定义factoryBean
        User userByFactoryBean = xmlApplicationContext.getBean("user-by-factory-bean", User.class);
        System.out.println(userByFactoryBean);
        
        // AutowireCapableBeanFactory
        AutowireCapableBeanFactory autowireCapableBeanFactory = xmlApplicationContext.getAutowireCapableBeanFactory();
        UserFactory userFactory = autowireCapableBeanFactory.createBean(AutowireFactory.class);
        System.out.println(userFactory.createUser());
	}

}
