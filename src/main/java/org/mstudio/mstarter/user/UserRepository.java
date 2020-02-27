package org.mstudio.mstarter.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Macrow
 * @date 2020/2/26
 */
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "UPDATE User t SET t.name = :name WHERE t.id = :id")
    void updateNameById(@Param("id") Long id, @Param("name") String name);
}
