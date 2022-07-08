package co.startech.co.quizeonlinesystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Component
@Entity
@Table(name = "results")
public class Result {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private int totalCorrect = 0;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Result() {
    }

    public Result(int id, String username, int totalCorrect) {
        super();
        this.id = id;
        this.username = username;
        this.totalCorrect = totalCorrect;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
    }
}
