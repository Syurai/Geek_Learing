package springBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Mark
public class User {
    private Long id;
    private String name;

    public static User createUserStatic() {
        User user = new User();
        user.setId(1L); 
        user.setName("静态方法装配");
        return user;
    }
}
