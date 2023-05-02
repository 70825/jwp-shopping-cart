package cart.controller;

import cart.service.MemberManagementService;
import cart.service.ProductManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final ProductManagementService productManagementService;
    private final MemberManagementService memberManagementService;

    public HomeController(
            final ProductManagementService productManagementService,
            final MemberManagementService memberManagementService
    ) {
        this.productManagementService = productManagementService;
        this.memberManagementService = memberManagementService;
    }

    @GetMapping("/")
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.addObject("products", productManagementService.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/settings")
    public ModelAndView settings(ModelAndView modelAndView) {
        modelAndView.addObject("members", memberManagementService.findAll());
        modelAndView.setViewName("settings");
        return modelAndView;
    }
}
