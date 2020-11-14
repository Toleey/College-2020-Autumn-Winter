package com.toleey.bbsmsg.dao.word;

import com.toleey.bbsmsg.pojo.Word;

import java.sql.Connection;
import java.util.List;

public interface WordDao {
    //查询数据库中敏感词

    public List<Word> findWord(Connection conn) throws Exception;
}
