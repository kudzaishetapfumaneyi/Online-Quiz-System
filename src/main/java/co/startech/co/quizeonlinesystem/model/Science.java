package co.startech.co.quizeonlinesystem.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "science")
public class Science {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quesId;

    private String title;
    private String optionA;
    private String optionB;
    private String optionC;

    private int chose;

    private int ans;

    public Science() {
        super();
    }

    public Science(int quesId, String title, String optionA, String optionB, String optionC, int chose, int ans) {
        this.quesId = quesId;
        this.title = title;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.chose = chose;
        this.ans = ans;
    }


    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public int getChose() {
        return chose;
    }

    public void setChose(int chose) {
        this.chose = chose;
    }

    @Override
    public String toString() {
        return "Science [quesId=" + quesId + ", title=" + title + ", optionA=" + optionA + ", optionB=" + optionB
                + ", optionC=" + optionC + ", ans=" + ans + ", chose=" + chose + "]";
    }
}
