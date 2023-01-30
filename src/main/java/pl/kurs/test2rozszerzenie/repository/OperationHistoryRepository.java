//package pl.kurs.test2rozszerzenie.repository;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface OperationHistoryRepository extends JpaRepository<OperationHistory, Long> {
//
//    List<OperationHistory> findAll();
//
//    List<OperationHistory> findByLocalDate(Date date);
//
//    List<OperationHistory> findByExpression(String expression);
//}