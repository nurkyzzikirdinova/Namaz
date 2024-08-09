package springprojectislam_dini.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.springprojectislam_dini.MyExeption.MyException;
import peaksoft.springprojectislam_dini.entity.Video;
import peaksoft.springprojectislam_dini.repository.UserRepository;
import peaksoft.springprojectislam_dini.repository.VideoRepository;
import peaksoft.springprojectislam_dini.service.VideoService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final UserRepository userRepository;

    @Override
    public void saveVideo(Video newVideo) {
        videoRepository.save(newVideo);
    }

    @Override
    public List<Video> findAllVideo() {
        return videoRepository.findAll();
    }

    @Override
    public Video findVideoById(Long videoId) {
        try {
            return videoRepository.findById(videoId).orElseThrow(() -> new MyException("Video not found!"));
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

//    @Override
//    public void updateVideoById(Long videoId, Video newVideo) throws MyException {
//        Video video = videoRepository.findById(videoId).orElseThrow(() -> new MyException("Agency not found!"));
//        video.setName(newVideo.getName());
//        video.setVideoUrl(newVideo.getVideoUrl());
//        videoRepository.save(video);
//
//    }

    @Override
    public void deleteVideoById(Long videoId) {
        videoRepository.deleteById(videoId);
    }


}
