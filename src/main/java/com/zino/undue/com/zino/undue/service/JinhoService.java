package com.zino.undue.com.zino.undue.service;

import com.google.gson.Gson;
import com.zino.undue.com.zino.undue.dao.JinhoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jo_seungwan on 2017. 5. 4..
 */
@Service
public class JinhoService {
    @Autowired
    JinhoDao jinhoDao;

    Gson gson = new Gson();

    public String selectAllList() {
        return gson.toJson(jinhoDao.selectAllList());
    }
    public String selectOne(String name) { return gson.toJson(jinhoDao.selectOne(name)); }
}
