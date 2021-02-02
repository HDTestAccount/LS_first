package by.yason.tools;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {
    @RequestMapping
    public String checkNum(@RequestParam(value = "num") String num) {

        try {
            Integer.parseInt(num);
            if (num.length() == 6) {
                multiFileWritter.write(num + "," + utils.isMyTicketLucky(num));
            }
        } catch (NumberFormatException e) {
        }

        return "Rq recived";
    }
}
