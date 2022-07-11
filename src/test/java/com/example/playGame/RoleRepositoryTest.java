package com.example.playGame;

import com.example.playGame.models.Role;
import com.example.playGame.repository.RoleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepositoryTest {
    @Autowired
    RoleRepository repo;
    @Test
    public void testCreateRoles(){
        Role user = new Role("USER");
        Role admin = new Role("ADMIN");

        repo.saveAll(List.of(user,admin));

        List<Role> listRoles = repo.findAll();

        Assertions.assertThat(listRoles.size()).isEqualTo(2);
    }
}
