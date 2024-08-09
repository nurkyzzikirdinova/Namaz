package springprojectislam_dini.service;

import peaksoft.springprojectislam_dini.entity.Video;

import java.util.List;

public interface VideoService {

    void saveVideo (Video newVideo);

    List<Video>findAllVideo();

    Video findVideoById(Long videoId);

//    void updateVideoById(Long videoId, Video newVideo) throws MyException;

    void deleteVideoById(Long videoId);


}
