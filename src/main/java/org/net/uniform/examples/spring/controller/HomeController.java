package org.net.uniform.examples.spring.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.net.uniform.api.Element;
import org.net.uniform.api.Form;
import org.net.uniform.examples.spring.forms.ExampleForm;
import org.springframework.beans.factory.annotation.Autowired;

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
            Map<String, Object> data = adaptFormData(formData, form);
            form.populate(data);

            model.addAttribute("valid", form.isValid());
            
            model.addAttribute("formData", form.getFormData());
        }

        model.addAttribute("form", form);
        
        return "home";
    }

    private Map<String, Object> adaptFormData(MultiValueMap<String, String> formData, Form form) {
        Map<String, Object> data = new HashMap<>();

        for (Element element : form.getElements().values()) {
            Class type = element.getValueType();

            if (type != null) {
                String id = element.getId();
                List<String> listValue = formData.get(id);
                String firstValue = formData.getFirst(id);

                System.out.println(type);
                if (type.equals(List.class)) {
                    data.put(id, listValue);
                } else {
                    data.put(id, firstValue);
                }
            }
        }

        return data;
    }
}
