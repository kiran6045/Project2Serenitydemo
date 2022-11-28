package starter.utility;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class Elementutil extends PageObject {



    public List<String> findelements(String xpath) {
        List<String> list = null;
        try {

            list = findAll(xpath).stream()
                    .map(WebElementFacade::getText)
                    .collect(Collectors.toList());
            System.out.println(list);

        } catch (Exception e) {
            //print error message if web Element is not found
            System.out.println("Web Element is not found in Page");
            System.out.println(e);

        }

        return list;
    }

}
