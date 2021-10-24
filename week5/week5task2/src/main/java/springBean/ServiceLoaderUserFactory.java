package springBean;

public class ServiceLoaderUserFactory implements UserFactory {
    //实现实例方法装配
    @Override
    public User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("ServiceLoader装配");
        return user;
    }
}
