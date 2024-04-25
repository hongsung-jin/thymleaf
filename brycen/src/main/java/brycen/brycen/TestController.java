package brycen.brycen;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

  @Value("${spring.profiles.active}")
  private String activeProfile;

  @GetMapping("/test")
  public String indexMethod(Model model) {
    model.addAttribute("activeProfile", activeProfile);
    return "test";
  }
  
  @GetMapping("/something")
  public String testMethod() {
    return "something";
  }
}
