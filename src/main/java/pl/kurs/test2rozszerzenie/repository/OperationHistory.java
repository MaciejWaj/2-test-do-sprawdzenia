//package pl.kurs.test2rozszerzenie.repository;
//import java.time.LocalDate;
//import java.util.Date;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class OperationHistory {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private LocalDate localDate;
//    private String expression;
//    private double result;
//
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public LocalDate getLocalDate() {
//        return localDate;
//    }
//
//    public void setLocalDate(LocalDate localDate) {
//        this.localDate = localDate;
//    }
//
//    public String getExpression() {
//        return expression;
//    }
//
//    public void setExpression(String expression) {
//        this.expression = expression;
//    }
//
//    public double getResult() {
//        return result;
//    }
//
//    public void setResult(double result) {
//        this.result = result;
//    }
//}