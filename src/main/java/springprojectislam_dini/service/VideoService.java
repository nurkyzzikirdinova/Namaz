package springprojectislam_dini.service;


import springprojectislam_dini.entity.Video;

import java.util.List;

public interface VideoService {

    void saveVideo (Video newVideo);

    List<Video> findAllVideo();

    Video findVideoById(Long videoId);

    void deleteVideoById(Long videoId);


}
