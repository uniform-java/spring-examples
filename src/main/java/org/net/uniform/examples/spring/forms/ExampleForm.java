package org.net.uniform.examples.spring.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.net.uniform.api.Validator;
import org.net.uniform.examples.spring.common.forms.UIkitForm;
import org.net.uniform.html.decorators.HTMLTagDecorator;
import org.net.uniform.html.elements.Button;
import org.net.uniform.html.elements.HTMLElement;
import org.net.uniform.html.elements.Input;
import org.net.uniform.html.elements.Multiselect;
import org.net.uniform.html.elements.Select;
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
        
        this.startDecorator("uno", new HTMLTagDecorator("div", new HashMap<String, Object>(){{
            put("class", "uk-grid");
        }}));

        this.startDecorator("dos", new HTMLTagDecorator("div", new HashMap<String, Object>(){{
            put("class", "uk-width-1-2");
        }}));
        
        //Input
        Input input = new Input("input");
        input.setLabel("Field 1");
        input.setProperty("class", "class");
        input.addClass("class2");
        input.setProperty("placeholder", "Input something...");
        input.setRequired(true);
        input.addValidator(new Validator<Input>() {

            @Override
            public List<String> getValidationErrors(Input e, List<String> value) {
                String text = UniformUtils.firstValue(value);
                
                if(text == null || !text.contains("ok")){
                    return new ArrayList<String>(){{
                        add("The value needs to contain 'ok'");
                    }};
                }

                return null;
            }

            @Override
            public boolean breakChainOnError() {
                return false;
            }
        });
        this.addElement(input);
        

        //Multiselect
        Multiselect multi = new Multiselect("multi");
        multi.setLabel("Field 2");
        multi.addOption("1", "One");
        multi.addOption("2", "Two");
        multi.addOption("3", "Three");
        multi.setValue(new ArrayList<String>(){{
            add("1");
            add("3");
        }});
        multi.setRequired(true);

        this.addElement(multi);
        
        this.endDecorator();//End column 1
        
        this.startDecorator("tres", new HTMLTagDecorator("div", new HashMap<String, Object>(){{
            put("class", "uk-width-1-2");
        }}));

        //Select
        Select select = new Select("select");
        select.setLabel("Field 3");
        select.addOption("", "---");
        select.addOption("a", "One");
        select.addOption("b", "Two");
        select.addOption("c", "Three");
        select.setValue("a");

        this.addElement(select);
        
        this.endDecorator();//End Column 2
        
        this.endDecorator();//End grid
        
        Button submit = new Button("submit", Button.BUTTON_TYPE_SUBMIT);
        submit.addClass("uk-button uk-button-primary");
        submit.setProperty("escape", "false");
        submit.setLabel("Submit");

        submit.addDecorator(new HTMLTagDecorator("div", new HashMap<String, Object>() {
            {
                put("class", "uk-text-center");
            }
        }));
        this.addElement(submit);
    }

}
