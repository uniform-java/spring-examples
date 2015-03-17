package org.net.uniform.examples.spring.common.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.net.uniform.api.Renderer;
import org.net.uniform.api.html.SimpleHTMLTag;
import org.net.uniform.html.elements.DatePicker;

/**
 *
 * @author Eduardo Ramos<eduramiba@gmail.com>
 */
public class UIkitDatepickerRenderer implements Renderer<DatePicker> {

    @Override
    public List<SimpleHTMLTag> render(DatePicker input) {
        Map<String, String> finalProps = new HashMap<>();
        finalProps.putAll(input.getProperties());

        String value = input.getFirstValue();
        finalProps.put("value", value != null ? value : "");
        finalProps.put("type", "text");
        finalProps.put("data-uk-datepicker", "{weekstart:0, format:'" + input.getDateFormat().toPattern().toUpperCase() + "'}");

        if (input.isRequired()) {
            finalProps.put("required", "required");
        }

        SimpleHTMLTag inputTag = new SimpleHTMLTag("input", finalProps);

        List<SimpleHTMLTag> result = new ArrayList<>();
        result.add(inputTag);

        return result;
    }

}
