package org.net.uniform.examples.spring.common.forms;



import java.util.List;
import net.uniform.api.Element;
import net.uniform.api.html.SimpleHTMLTag;
import net.uniform.impl.AbstractSingleElementDecorator;

/**
 *
 * @author Eduardo Ramos<eduramiba@gmail.com>
 */
public class UIkitErrorsDecorator extends AbstractSingleElementDecorator {

    public UIkitErrorsDecorator() {
    }

    @Override
    protected List<SimpleHTMLTag> render(Element element, List<SimpleHTMLTag> rendered) {
        if (rendered.size() == 1 && element.validationPerformed() && !element.isValid()) {
            String currentClass = rendered.get(0).getProperty("class");
            if (currentClass == null) {
                currentClass = "";
            }

            rendered.get(0).setProperty("class", currentClass + " uk-form-danger");
        }

        return rendered;
    }
}
