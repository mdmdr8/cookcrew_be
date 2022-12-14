package kfq.cookcrew.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    Boolean existsByNickname(String nickname);
    Boolean existsByPassword(String password);


}

