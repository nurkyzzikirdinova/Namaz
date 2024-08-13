package springprojectislam_dini.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springprojectislam_dini.MyExeption.MyException;
import springprojectislam_dini.entity.Video;
import springprojectislam_dini.repository.UserRepository;
import springprojectislam_dini.repository.VideoRepository;
import springprojectislam_dini.service.VideoService;

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

    @Override
    public void deleteVideoById(Long videoId) {
        videoRepository.deleteById(videoId);
    }


}
