package Web.config;


import Web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import Web.service.UserService;

@Controller
public class WebConfig {

    private final UserService userService;

    public WebConfig(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("users", new User());
        return "info";
    }
    @PostMapping("/saveUser")
    public String createUser(@ModelAttribute("users") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("users", userService.getUserById(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("users") User user, @PathVariable("id") long id) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String delete(@ModelAttribute("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}