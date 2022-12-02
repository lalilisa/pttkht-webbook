package com.n10.webbook.repository.customer;

import com.n10.webbook.entity.Fullname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullNameRepository extends JpaRepository<Fullname,Long> {
}
