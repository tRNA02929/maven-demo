package com.ksyun.libo.service;

import com.ksyun.libo.dto.NetCutApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetCutApiService {
    @Autowired
    private NetCutApiDTO netCutApiDTO;

    public String getFile(String key) {
        return netCutApiDTO.getText(key);
    }

    public String postFile(String key, String upload) {
        return netCutApiDTO.postText(key, upload);
    }
}
