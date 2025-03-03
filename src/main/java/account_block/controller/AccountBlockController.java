package account_block.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountBlockController {

    @GetMapping("/up")
    @ResponseStatus(HttpStatus.OK)
    public String up() {
        return "yes, I am up";
    }
}