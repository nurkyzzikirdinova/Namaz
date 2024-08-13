package springprojectislam_dini.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springprojectislam_dini.MyExeption.MyException;
import springprojectislam_dini.entity.NamazTime;
import springprojectislam_dini.service.NamaztimeService;

@Controller
@RequestMapping("/namazItems")
@RequiredArgsConstructor

public class NamazitemController {

    private final NamaztimeService namaztimeService;

    @GetMapping("/new")
    public String createNamazitem(Model model){
        model.addAttribute("newnNamazitem", new NamazTime());
        return "/namazitem/new-namazitem";
    }

    @PostMapping("/newNamazitem")
    public String saveNamazitem(@ModelAttribute("newNamazitem") NamazTime namazTime){
        namaztimeService.saveNamaxtime(namazTime);
        return "redirect:/namazItems/namazitem";
    }

    @GetMapping
    public String getAllNamazItem(Model model){
        model.addAttribute("namazitem", namaztimeService.findAllNamazTime());
        return "/home-pagh";
    }

    @GetMapping("/namazitem")
    public String getNamazItem(Model model){
        model.addAttribute("namazitem", namaztimeService.findAllNamazTime());
        return "/namazitem/namaztime-main";
    }



    @GetMapping("/update/{namazitemId}")
    public String getById(@PathVariable Long namazitemId, Model model) throws MyException {
        model.addAttribute("namazitem", namaztimeService.findById(namazitemId));
        return "/namazitem/update-namaztime";
    }


    @PostMapping("/update/{namazitemId}")
    public String updateNamazitem(@PathVariable Long namazitemId, @ModelAttribute("namazitem") NamazTime namazTime){
        namaztimeService.updateNamazTimeById(namazitemId, namazTime);
        return "redirect:/namazItems/namazitem";
    }



    @PostMapping("/{namazitemId}/delete")
    public String delete (@PathVariable Long namazitemId){
        namaztimeService.deleteNamazTimeId(namazitemId);
        return "redirect:/namazItems/namazitem";
    }

}
