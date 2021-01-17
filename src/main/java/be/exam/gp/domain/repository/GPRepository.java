package be.exam.gp.domain.repository;

import be.exam.gp.domain.GPEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GPRepository extends JpaRepository<GPEntity, Long> {
}
