package org.net.uniform.examples.spring.common.forms;



import java.util.List;
import org.net.uniform.api.Element;
import org.net.uniform.api.html.SimpleHTMLTag;
import org.net.uniform.impl.AbstractSingleElementDecorator;

/**
 *
 * @author Eduardo Ramos<eduramiba@gmail.com>
 */
public class UIkitErrorsDecorator extends AbstractSingleElementDecorator {

    public UIkitErrorsDecorator() {
    }

    @Override
    protected List<SimpleHTMLTag> render(Element element, List<SimpleHTMLTag> rendered) {
        if (element.validationPerformed() && !element.getValidationErrors().isEmpty()) {
            String currentClass = rendered.get(0).getProperty("class");
            if (currentClass == null) {
                currentClass = "";
            }

            rendered.get(0).setProperty("class", currentClass + " uk-form-danger");
        }

        return rendered;
    }
}
