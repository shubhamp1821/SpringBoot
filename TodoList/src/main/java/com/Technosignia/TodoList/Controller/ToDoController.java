package com.Technosignia.TodoList.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Technosignia.TodoList.Model.ToDo;
import com.Technosignia.TodoList.Service.ToDoService;

@Controller
public class ToDoController {

    private static final Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @Autowired
    private ToDoService service;

    @GetMapping({"/", "ViewToDoList"})
    public String viewAllToDoItems(Model model, @ModelAttribute String message) {
        if (message == null) {
            message = ""; // Handle the case where message might be null
        }
        model.addAttribute("list", service.getAllToDoItems());
        model.addAttribute("msg", message);
        return "ViewToDoList"; // Ensure this matches the JSP file name
    }

    @PostMapping("/updatedToDoStatus")
    public String updateToDoStatus(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        logger.info("Updating status for ToDo item with ID: {}", id);
        if (service.updateStatus(id)) {
            redirectAttributes.addFlashAttribute("message", "Update Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Update Failure");
        }
        return "redirect:/ViewToDoList"; // Ensure this matches the controller method
    }

    @GetMapping("/addToDoItem")
    public String addToDoItem(Model model) {
        model.addAttribute("todo", new ToDo());
        return "AddToDoItem"; // Ensure this matches the JSP file name
    }

    @PostMapping("/saveToDoItem")
    public String saveToDoItem(ToDo todo, RedirectAttributes redirectAttributes) {
        logger.info("Saving ToDo item: {}", todo);
        if (service.saveOrUpdateToDoItem(todo)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Save Failure");
        }
        return "redirect:/addToDoItem"; // Redirect to same page if saving fails
    }

    @GetMapping("/editToDoItem/{id}")
    public String editToDoItem(@PathVariable Long id, Model model) {
        model.addAttribute("todo", service.getToDoItemById(id));
        return "EditToDoItem"; // Ensure this matches the JSP file name
    }

    @PostMapping("/editSaveToDoItem")
    public String editSaveToDoItem(ToDo todo, RedirectAttributes redirectAttributes) {
        logger.info("Editing ToDo item: {}", todo);
        if (service.saveOrUpdateToDoItem(todo)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/ViewToDoList"; // Redirect to list view on success
        } else {
            redirectAttributes.addFlashAttribute("message", "Edit Failure");
            return "redirect:/editToDoItem/" + todo.getId(); // Redirect back to edit on failure
        }
    }

    @GetMapping("/deleteToDoItem/{id}")
    public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        logger.info("Deleting ToDo item with ID: {}", id);
        if (service.deleteToDoItem(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }
        return "redirect:/ViewToDoList"; // Redirect to list view after deletion
    }
}
