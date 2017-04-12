package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Description：
 *
 * @author: ChenXiangzhen
 * create 2017-04-12-17:37
 */
public interface PictureService {

    Map uploadPicture(MultipartFile uploadFile);

}
