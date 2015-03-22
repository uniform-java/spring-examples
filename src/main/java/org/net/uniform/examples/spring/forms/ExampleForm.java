package org.net.uniform.examples.spring.forms;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.net.uniform.api.Validator;
import org.net.uniform.examples.spring.common.forms.UIkitForm;
import org.net.uniform.html.decorators.HTMLTagDecorator;
import org.net.uniform.html.elements.Button;
import org.net.uniform.html.elements.Checkbox;
import org.net.uniform.html.elements.DatePicker;
import org.net.uniform.html.elements.HTMLElement;
import org.net.uniform.html.elements.Input;
import org.net.uniform.html.elements.Multicheckbox;
import org.net.uniform.html.elements.Multiselect;
import org.net.uniform.html.elements.Radio;
import org.net.uniform.html.elements.Select;
import org.net.uniform.html.elements.Textarea;
import org.net.uniform.impl.utils.UniformUtils;

/**
 *
 * @author Eduardo Ramos<eduramiba@gmail.com>
 */
public class ExampleForm extends UIkitForm {

    public ExampleForm() {
        super();
        this.addClass("uk-form-horizontal");

        HTMLElement header = new HTMLElement("header", "h2");
        header.setProperty("class", "header-class");
        header.setContent("<i class=\"uk-icon-cog\"></i> Submit me please");
        this.addElement(header);
        
        //Start grid
        this.startDecorator("grid", new HTMLTagDecorator("div", new HashMap<String, Object>(){{
            put("class", "uk-grid");
        }}));

        //Start column 1
        this.startDecorator("col1", new HTMLTagDecorator("div", new HashMap<String, Object>(){{
            put("class", "uk-width-1-2");
        }}));
        
        //Input
        Input input = new Input("input");
        input.setLabel("Text input");
        input.setProperty("class", "class");
        input.addClass("class2");
        input.setProperty("placeholder", "Input something...");
        input.setRequired(true);
        input.addValidator(new Validator<Input>() {

            @Override
            public List<String> getValidationErrors(Input e, List<String> value) {
                String text = UniformUtils.firstValue(value);
                
                if(text == null || !text.contains("ok")){
                    return Arrays.asList("The value needs to contain 'ok'");
                }

                return null;
            }

            @Override
            public boolean breakChainOnError() {
                return false;
            }
        });
        this.addElement(input);
        
        //Password
         Input password = new Input("pass");
        password.setLabel("Password");
        password.setProperty("type", "password");
        
        this.addElement(password);
        

        //Multiselect
        Multiselect multi = new Multiselect("multi-select");
        multi.setLabel("Multiselect");
        multi.addOption("1", "One");
        multi.addOption("2", "Two");
        multi.addOption("3", "Three");
        multi.setValue(Arrays.asList("1", "3"));
        multi.setRequired(true);

        this.addElement(multi);
        
        //Radio
        Radio radio = new Radio("radio");
        radio.setLabel("Radio");
        radio.addOption("a", "One");
        radio.addOption("b", "Two");
        radio.addOption("c", "Three");
        radio.setRequired(true);
        
        this.addElement(radio);
        
        this.endDecorator();//End column 1
        
        //Start column 2
        this.startDecorator("col2", new HTMLTagDecorator("div", new HashMap<String, Object>(){{
            put("class", "uk-width-1-2");
        }}));
        
        DatePicker datePicker = new DatePicker("date");
        datePicker.setLabel("Some date (optional)");
        datePicker.setValue(new Date());
        this.addElement(datePicker);

        //Select
        Select select = new Select("select");
        select.setLabel("Select");
        select.addOption("", "---");
        select.addOption("a", "One");
        select.addOption("b", "Two");
        select.addOption("c", "Three");
        select.setValue("a");

        this.addElement(select);
        
        Textarea textarea = new Textarea("txt");
        textarea.setLabel("Textarea");
        textarea.setProperty("placeholder", "Input something...");
                
        this.addElement(textarea);
        
        //Checkbox
        Checkbox chk = new Checkbox("check");
        chk.setLabel("Checkbox");
        this.addElement(chk);
        
        //Multi checkbox
        Multicheckbox multiCheck = new Multicheckbox("check-multi");
        multiCheck.setLabel("Multi-checkbox");
        multiCheck.addOption("a", "One");
        multiCheck.addOption("b", "Two");
        multiCheck.addOption("c", "Three");
        multiCheck.setRequired(true);
        
        this.addElement(multiCheck);
        
        this.endDecorator();//End Column 2
        
        this.endDecorator();//End grid
        
        Button submit = new Button("submit", Button.BUTTON_TYPE_SUBMIT);
        submit.addClass("uk-button uk-button-primary");
        submit.setEscape(false);
        submit.setLabel("<i class=\"uk-icon-check\"></i> Submit");

        submit.addDecorator(new HTMLTagDecorator("div", new HashMap<String, Object>() {
            {
                put("class", "uk-text-center");
            }
        }));
        this.addElement(submit);
    }

}
