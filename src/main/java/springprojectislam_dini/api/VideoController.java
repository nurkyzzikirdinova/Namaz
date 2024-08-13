package springprojectislam_dini.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springprojectislam_dini.entity.Video;
import springprojectislam_dini.service.VideoService;

@Controller
@RequestMapping("/videos")
@RequiredArgsConstructor

public class VideoController {
    private final VideoService videoService;

    @GetMapping("/new")
    public String createVideo(Model model){
        model.addAttribute("Newvideo", new Video());
        return "/video/newVideo";
    }

    @PostMapping("/newVideo")
    public String saveVideo(@ModelAttribute Video video){
        videoService.saveVideo(video);
        return "redirect:/videos/video";
    }

    @GetMapping
    public String finAllVideo(Model model){
        model.addAttribute("video", videoService.findAllVideo());
        return "/home-pagh";
    }

    @GetMapping("/video")
    public String getVideo(Model model){
        model.addAttribute("videos", videoService.findAllVideo());
        return "video/video-main";
    }

    @PostMapping("/{videoId}/delete")
    public String delete(@PathVariable Long videoId){
        videoService.deleteVideoById(videoId);
        return "redirect:/videos/video";
    }



}
