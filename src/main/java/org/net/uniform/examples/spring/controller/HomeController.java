package org.net.uniform.examples.spring.controller;

import net.uniform.api.Form;
import org.net.uniform.examples.spring.forms.ExampleForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homeGet(Model model, @RequestParam MultiValueMap<String, String> formData) {
        return doHome(model, formData, false);
    }
    
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.POST)
    public String homePost(Model model, @RequestParam MultiValueMap<String, String> formData) {
        return doHome(model, formData, true);
    }

    private String doHome(Model model, MultiValueMap<String, String> formData, boolean isPost) {
        Form form = new ExampleForm();
        
        if (isPost) {
            System.out.println(formData);
            form.populate(formData);

            model.addAttribute("valid", form.isValid());
            
            model.addAttribute("formData", form.getFormData());
            model.addAttribute("formDataConverted", form.getFormDataConvertedToElementValueTypes());
        }

        model.addAttribute("form", form);
        
        return "home";
    }
}
