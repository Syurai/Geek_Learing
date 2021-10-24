package springBean;

//AutowireCapableBeanFactory
//自动注入的是AutowireFactory，然后调用了这个bean的方法
public class AutowireFactory implements UserFactory {

 @Override
 public User createUser() {
     User user = new User();
     user.setId(1L);
     user.setName("AutowireFactory装配");
     return user;
 }
}
