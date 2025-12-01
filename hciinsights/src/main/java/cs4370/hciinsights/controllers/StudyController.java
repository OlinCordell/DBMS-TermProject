package cs4370.hciinsights.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import cs4370.hciinsights.services.StudyService;
import cs4370.hciinsights.services.UserService;
import cs4370.hciinsights.models.Status;

@Controller
@RequestMapping("/studies")
public class StudyController {

    private final StudyService studyService;
    private final UserService userService;

    @Autowired
    public StudyController(StudyService studyService, UserService userService) {
        this.studyService = studyService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView webpage(@RequestParam(name = "error", required = false) String error) {
        
        ModelAndView mv = new ModelAndView("studies");

        try {      
            int userId = userService.getLoggedInUser().getUserId();
            mv.addObject("studies", studyService.getStudiesByUser(userId));
        } catch (Exception e) {
            mv.addObject("errorMessage", "Failed to load studies");
        }

        mv.addObject("loggedInUser", userService.getLoggedInUser());
        mv.addObject("errorMessage", error);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView createStudyPage(@RequestParam(name = "error", required = false) String error) {

        ModelAndView mv = new ModelAndView("create_study");

        mv.addObject("loggedInUser", userService.getLoggedInUser());
        mv.addObject("errorMessage", error);
        mv.addObject("statuses", Status.values());

        return mv;
    }

    @PostMapping("/create")
    public String createStudy(
        @RequestParam("title") String title,
        @RequestParam("description") String description,
        @RequestParam("platform") String platform,
        @RequestParam("status") Status status
    ) {
        try {
            int userId = userService.getLoggedInUser().getUserId();

            boolean success = studyService.createStudy(
                userId, title, description, platform, status
            );

            if (success) {
                return "redirect:/studies";
            } else {
                return "redirect:/studies/create?error=Error during study creation.";
            }
        } catch (Exception e) {
            String msg = "Error: " + e.getMessage();
            return "redirect:/studies/create?error=" + msg;
        }
    }

    @GetMapping("/{id}")
    public ModelAndView viewStudy(@PathVariable("id") int studyId) {
        ModelAndView mv = new ModelAndView("study_detail");
        try {
            mv.addObject("study", studyService.getStudyById(studyId));
            mv.addObject("studyId", studyId);
        } catch (Exception e) {
            mv.addObject("errorMessage", "Could not load study.");
        }
        return mv;
    }

    @PostMapping("/{id}/delete")
    public String deleteStudy(@PathVariable("id") int studyId) {
        // TODO: add more later
        return "redirect:/studies";
    }

}