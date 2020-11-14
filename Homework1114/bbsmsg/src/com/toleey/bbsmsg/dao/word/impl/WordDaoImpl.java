package com.toleey.bbsmsg.dao.word.impl;

import com.toleey.bbsmsg.dao.BaseDao;
import com.toleey.bbsmsg.dao.word.WordDao;
import com.toleey.bbsmsg.pojo.Word;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WordDaoImpl extends BaseDao implements WordDao {
    @Override
    public List<Word> findWord(Connection conn) throws Exception {
        String sql = "select * from dirtywords";
        ResultSet rst = execQuery(sql);
        List<Word> wordList = new ArrayList<Word>();
        while(rst.next()){
            Word word = new Word();
            word.setId(rst.getInt("id"));
            word.setWord(rst.getString("word"));
            wordList.add(word);
        }
        closeDB(rst,null,null);
        return wordList;
    }
}
