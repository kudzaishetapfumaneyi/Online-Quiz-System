package co.startech.co.quizeonlinesystem.service;

import co.startech.co.quizeonlinesystem.model.Question;
import co.startech.co.quizeonlinesystem.model.QuestionForm;
import co.startech.co.quizeonlinesystem.model.Result;
import co.startech.co.quizeonlinesystem.model.Science;
import co.startech.co.quizeonlinesystem.repository.QuestionRepo;
import co.startech.co.quizeonlinesystem.repository.ResultRepo;
import co.startech.co.quizeonlinesystem.repository.ScienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScienceService {

    @Autowired
    Science science;

    @Autowired
    QuestionForm qForm;

    @Autowired
    ScienceRepo qRepo;

    @Autowired
    Result result;

    @Autowired
    ResultRepo rRepo;

    public QuestionForm getScience() {
        List<Science> allQues = qRepo.findAll();
        List<Science> qList = new ArrayList<Science>();

        Random random = new Random();
        //if(!allQues.isEmpty()) {
        for(int i=0; i<14; i++) {


            int rand = random.nextInt(allQues.size());
            qList.add(allQues.get(rand));
            allQues.remove(rand);
        }
        // }

        qForm.setScience(qList);

        return qForm;

    }
    public int getResult(QuestionForm qForm) {
        int totalCorrect = 0;

        for(Science q: qForm.getScience())
            if(q.getAns() == q.getChose())
                totalCorrect++;

        return totalCorrect;
    }

    public void saveScore(Result result) {
        Result saveResult = new Result();
        saveResult.setUsername(result.getUsername());
        saveResult.setTotalCorrect(result.getTotalCorrect());
        rRepo.save(saveResult);
    }

    public List<Result> getTopScore() {
        List<Result> sList =
                rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));

        return sList;
    }

    public void deleteStudentById(Long id) {

    }
}
