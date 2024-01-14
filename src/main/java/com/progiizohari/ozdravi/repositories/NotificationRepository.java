package com.progiizohari.ozdravi.repositories;

import com.progiizohari.ozdravi.domain.Notification;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findAllByParent_OIB(String parent_OIB);

    List<Notification> findNotificationsByChildIsNullAndParent_OIB(String parent_OIB);

    List<Notification> findNotificationsByChild_OIB(String child_OIB);
}
