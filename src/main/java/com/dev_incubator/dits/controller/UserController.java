package com.dev_incubator.dits.controller;

import com.dev_incubator.dits.persistence.entity.Role;
import com.dev_incubator.dits.service.dto.UserDto;
import com.dev_incubator.dits.service.interfaces.RoleService;
import com.dev_incubator.dits.service.interfaces.UserService;
import com.dev_incubator.dits.util.MessageSourceFacade;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Controller
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private final RoleService roleService;

    private final MessageSourceFacade messageSource;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "user-list";
    }

    @GetMapping(value = "/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showUserForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "user";
    }

    @PostMapping(value = "/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveUser(@ModelAttribute("user") @Valid UserDto user,
                           BindingResult bindingResult,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "user";
        }
        if (!userService.saveUser(user)) {
            model.addAttribute("loginError", messageSource.getMessage("user.already.exist"));
            return "user";
        }
        if (isNull(user.getId())) {
            redirectAttributes.addFlashAttribute("report", messageSource.getMessage("user.create.success"));
        } else {
            redirectAttributes.addFlashAttribute("report", messageSource.getMessage("user.update.success"));
        }

        return "redirect:/users";
    }

    @GetMapping(value = "/edit/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showEditUserForm(@PathVariable(value = "userId", required = true) Long userId,
                                   Model model) {
        UserDto user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user";
    }


    @GetMapping(value = "/login")
    public String login(
            @RequestParam(name = "error", required = false) String error,
            @RequestParam(name = "logout", required = false) String logout,
            Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getPrincipal().equals("anonymousUser")) {
            model.asMap().clear();
            return "redirect:/";
        }
        if(nonNull(error) && error.equals("blocked")){
            model.addAttribute("report", messageSource.getMessage("user.blocked"));
        }
        if(nonNull(error) && error.equals("bad_credential")){
            model.addAttribute("report", messageSource.getMessage("user.bad.credentials"));
        }
        if(nonNull(logout)){
            model.addAttribute("report", messageSource.getMessage("user.logout.success"));
        }
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        model.asMap().clear();
        return "redirect:/users/login?logout";
    }

    @GetMapping(value = "/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("user") @Valid UserDto user,
                               BindingResult bindingResult,
                               Model model,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.getErrorCount() > 1) {
            return "registration";
        }
        if (!userService.saveUser(user)) {
            model.addAttribute("loginError", messageSource.getMessage("user.already.exist"));
            return "registration";
        }
        redirectAttributes.addFlashAttribute("report", messageSource.getMessage("user.registration.success"));
        return "redirect:/users/login";
    }

    @ModelAttribute("roleList")
    public List<Role> getRoleList() {
        return roleService.getAll();
    }

    @GetMapping(value = "/re-block/{userId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String changeUserBlockStatus(
            @PathVariable(value = "userId", required = true) Long userId,
            RedirectAttributes redirectAttributes) {
        if (userService.changeBlockStatus(userId)) {
            redirectAttributes.addFlashAttribute("report", messageSource.getMessage("user.unblocked"));
        } else {
            redirectAttributes.addFlashAttribute("report", messageSource.getMessage("user.blocked"));
        }
        return "redirect:/users";
    }
}
