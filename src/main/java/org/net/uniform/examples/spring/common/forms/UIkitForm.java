package org.net.uniform.examples.spring.common.forms;



import java.util.HashMap;
import org.net.uniform.html.HTMLForm;
import org.net.uniform.html.decorators.HTMLErrorsDecorator;
import org.net.uniform.html.decorators.HTMLTagDecorator;
import org.net.uniform.html.decorators.LabelDecorator;

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
    protected void setupDefaultDecorators() {
        defaultGlobalDecorators.add(new UIkitErrorsDecorator());

        defaultGlobalDecorators.add(new HTMLTagDecorator("div", new HashMap<String, Object>() {
            {
                put("class", "uk-form-controls");
            }
        }));
        defaultGlobalDecorators.add(new LabelDecorator("uk-form-label"));
        defaultGlobalDecorators.add(new HTMLErrorsDecorator("uk-text-danger"));
        defaultGlobalDecorators.add(new HTMLTagDecorator("div", new HashMap<String, Object>() {
            {
                put("class", "uk-form-row");
            }
        }));
    }

}
