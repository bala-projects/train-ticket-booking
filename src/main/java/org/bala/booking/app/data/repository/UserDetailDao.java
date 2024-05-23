package org.bala.booking.app.data.repository;

import org.bala.booking.app.data.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailDao extends JpaRepository<UserDetail, Long> {

}
