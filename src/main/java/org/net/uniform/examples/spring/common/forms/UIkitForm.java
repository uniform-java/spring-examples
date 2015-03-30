package org.net.uniform.examples.spring.common.forms;



import java.util.HashMap;
import net.uniform.api.Element;
import net.uniform.html.HTMLForm;
import net.uniform.html.decorators.ElementErrorsDecorator;
import net.uniform.html.decorators.HTMLTagDecorator;
import net.uniform.html.decorators.LabelDecorator;
import net.uniform.html.elements.DatePicker;

/**
 *
 * @author Eduardo Ramos<eduramiba@gmail.com>
 */
public class UIkitForm extends HTMLForm {

    public UIkitForm() {
        super();
        this.addClass("uk-form");
    }

    @Override
    protected void setupDefaultRenderers() {
        super.setupDefaultRenderers();
        this.defaultRenderers.put(DatePicker.class, new UIkitDatepickerRenderer());
    }

    @Override
    protected void setupDefaultDecorators() {
        addDefaultDecoratorForElementClass(Element.class, new UIkitErrorsDecorator());

        addDefaultDecoratorForElementClass(Element.class, new HTMLTagDecorator("div", new HashMap<String, Object>() {
            {
                put("class", "uk-form-controls");
            }
        }));
        addDefaultDecoratorForElementClass(Element.class, new LabelDecorator("uk-form-label"));
        addDefaultDecoratorForElementClass(Element.class, new ElementErrorsDecorator("uk-text-danger"));
        addDefaultDecoratorForElementClass(Element.class, new HTMLTagDecorator("div", new HashMap<String, Object>() {
            {
                put("class", "uk-form-row");
            }
        }));
    }

}
