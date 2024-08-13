package springprojectislam_dini.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springprojectislam_dini.entity.Namaz;
import springprojectislam_dini.service.NamazService;

import java.util.List;


@Controller
@RequestMapping("/namazs")
@RequiredArgsConstructor
public class NamazController {
    private final NamazService namazService;

    @GetMapping("/new")
    public String createNamaz(Model model){
        model.addAttribute("newNamaz", new Namaz());
        return "/namaz/newNamaz";
    }

    @PostMapping("/newNamaz")
    public String saveNamaz(@ModelAttribute Namaz namaz){
        namazService.saveNamaz(namaz);
        return "redirect:/namazs/namaz";
    }

    @GetMapping
    public String getAllNamaz(Model model){
        model.addAttribute("namazs", namazService.findAllNamaz());
        return "/home-pagh";
    }

    @GetMapping("/namaz")
    public String getNamaz(Model model){
        model.addAttribute("namazs", namazService.findAllNamaz());
        return "/namaz/namaz-main";
    }

    @GetMapping("/update/{namazId}")
    public String getById(@PathVariable Long namazId, Model model){
        model.addAttribute("namaz", namazService.findAllById(namazId));
        return "/namaz/update-namaz";
    }


    @PostMapping("/update/{namazId}")
    public String updateNamaz(@PathVariable("namazId") Long namazId,@ModelAttribute Namaz namaz){
        namazService.updateNamaz(namazId, namaz);
        return "redirect:/namazs/namaz";
    }

    @PostMapping("/{namazId}/delete")
    public String delete(@PathVariable Long namazId){
        namazService.deleteById(namazId);
        return "redirect:/namazs/namaz";
    }

    @GetMapping("/search")
    public String searchNamaz(@RequestParam String word, Model model){
        List<Namaz> namazs = namazService.NamazSearch(word);
        model.addAttribute("namazs", namazs);
        return "/namaz/namaz-search";
    }
}
