package org.mstudio.mstarter.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Macrow
 * @date 2020/2/26
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "UPDATE User t SET t.name = ?2 WHERE t.id = ?1")
    void updateNameById(Long id, String name);
}
