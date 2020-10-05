package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
    private UserRepository urepository;

    @Test
    public void findByUsernameShouldReturnEmail() {
        List<User> users = urepository.findByEmail("user@bookstore.fi");
        
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getUsername()).isEqualTo("user");
    }
    
    @Test
    public void createNewUser() {
    	User user = new User("test", "$2a$10$KVu/rKf1a4TA7igvm.eEbO.LHJEWu1lrix1C/k.OA.NfmT27Jptay", "test@bookstore.fi", "USER");
    	urepository.save(user);
    	assertThat(user.getId()).isNotNull();
    }
    
    @Test
    public void deleteUser() {
    	List <User> users = urepository.findByEmail("user@bookstore.fi");
    	urepository.deleteById(users.get(0).getId());
    	assertThat(users.isEmpty());
    } 

}
