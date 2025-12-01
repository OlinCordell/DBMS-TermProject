package cs4370.hciinsights.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import cs4370.hciinsights.services.TaskService;
import cs4370.hciinsights.services.UserService;

@Controller
@RequestMapping("/studies/{studyId}/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView viewTasks(@PathVariable("studyId") int studyId) {

        ModelAndView mv = new ModelAndView("tasks");

        try {
            mv.addObject("tasks", taskService.getTasksByStudy(studyId));
        } catch (Exception e) {
            mv.addObject("errorMessage", "Failed to load tasks.");
        }

        mv.addObject("studyId", studyId);
        mv.addObject("loggedInUser", userService.getLoggedInUser());
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView createTaskPage(@PathVariable("studyId") int studyId) {
        ModelAndView mv = new ModelAndView("create_tasks");
        mv.addObject("studyId", studyId);
        mv.addObject("loggedInUser", userService.getLoggedInUser());
        return mv;
    }

    @PostMapping("/create")
    public String createTask(@PathVariable("studyId") int studyId,
                            @RequestParam("taskOrder") int taskOrder,
                            @RequestParam("description") String description,
                            @RequestParam("successCriteria") String successCriteria,
                            @RequestParam("expectedCompTime") int expectedCompTime) {
        
        try {
            boolean success = taskService.createTask(
                studyId, taskOrder, description, successCriteria, expectedCompTime
            );

            if (success) {
                return "redirect:/studies/" + studyId + "/tasks";
            } else {
                return "redirect:/studies/" + studyId + "/tasks/create?error=CreateFailed";
            }
        } catch (Exception e) {
            return "redirect:/studies/" + studyId + "/tasks/create?error=" + e.getMessage();
        }
    }

}