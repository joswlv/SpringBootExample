package com.zino.undue.com.zino.undue.dao;

import com.zino.undue.com.zino.undue.model.JinhoModel;

import java.util.List;

/**
 * Created by Jo_seungwan on 2017. 5. 4..
 */
public interface JinhoDao {
    public List<JinhoModel> selectAllList();
    public JinhoModel selectOne(String name);
}
