package co.startech.co.quizeonlinesystem.controller;

import co.startech.co.quizeonlinesystem.model.QuestionForm;
import co.startech.co.quizeonlinesystem.model.Result;
import co.startech.co.quizeonlinesystem.model.User;
import co.startech.co.quizeonlinesystem.repository.UserRepository;
import co.startech.co.quizeonlinesystem.service.QuizService;
import co.startech.co.quizeonlinesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    Result result;

    @Autowired
    QuizService qService;

    Boolean submitted = false;

    @ModelAttribute("result")
    public Result getResult(){
        return result;
    }

    @GetMapping("homepage")
    public String viewHomePage() {
        return "homepage";
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @PostMapping("/selectSubject")
    public String selectSubject(@RequestParam String username,RedirectAttributes ra) {
        if(username.equals("")) {
            ra.addFlashAttribute("warning", "You must enter your name");
            return "redirect:/";
        }

        submitted = false;
        result.setUsername(username);


        return "selectSubject";
    }


    @PostMapping("/quiz")
    public String quiz( Model m) {


        QuestionForm qForm = qService.getQuestions();
        m.addAttribute("qForm", qForm);

        return "quiz";
    }

    @PostMapping("/english")
    public String english( Model m) {

        QuestionForm qForm = qService.getQuestions();
        m.addAttribute("qForm", qForm);

        return "english";
    }

    @PostMapping("/science")
    public String science( Model m) {

        QuestionForm qForm = qService.getQuestions();
        m.addAttribute("qForm", qForm);

        return "science";
    }



    @PostMapping("/submit")
    public String submit(@ModelAttribute QuestionForm qForm, Model m) {
        if(!submitted) {
            result.setTotalCorrect(qService.getResult(qForm));
            qService.saveScore(result);
            submitted = true;
        }

        return "result";
    }

    @GetMapping("/score")
    public String score(Model m) {
        List<Result> sList = qService.getTopScore();
        m.addAttribute("sList", sList);

        return "scoreboard";
    }

    @GetMapping("/score/{id}")
    public String deleteStudent(@PathVariable Long id) {
        qService.deleteStudentById(id);
        return "redirect:/score";
    }

//    kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk

//    @Autowired
//    UserService userService;
//
//    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login"); // resources/template/login.html
//        return modelAndView;
//    }
//
//    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
//    public ModelAndView register(){
//        ModelAndView modelAndView = new ModelAndView();
//        User user = new User();
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("register"); // resources/template/register.html
//        return modelAndView;
//    }
//
//    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("home"); // resources/template/home.html
//        return modelAndView;
//    }
//
//    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
//    public ModelAndView adminHome(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("admin"); // resources/template/admin.html
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap){
//        ModelAndView modelAndView = new ModelAndView();
//        if(bindingResult.hasErrors()){
//            modelAndView.addObject("successMessage", "Please add correct details!");
//            modelMap.addAttribute("bindingResult", bindingResult);
//        }else if(userService.isUserPresent(user)){
//            modelAndView.addObject("successMessage", "User already exists!");
//        }else {
//            userService.saveUser(user);
//            modelAndView.addObject("successMessage", "User registered successfully!");
//        }
//        modelAndView.addObject("user", new User());
//        modelAndView.setViewName("register");
//        return modelAndView;
//    }
}
