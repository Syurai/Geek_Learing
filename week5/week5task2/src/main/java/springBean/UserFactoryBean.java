package springBean;

import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("FactoryBean装配");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}
}
