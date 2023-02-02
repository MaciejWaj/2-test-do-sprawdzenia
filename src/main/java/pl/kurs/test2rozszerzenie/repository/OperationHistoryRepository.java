package pl.kurs.test2rozszerzenie.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface OperationHistoryRepository extends JpaRepository<OperationHistory, Long> {

}