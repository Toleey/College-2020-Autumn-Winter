package com.toleey.bbsmsg.service.word.impl;

import com.toleey.bbsmsg.dao.word.impl.WordDaoImpl;
import com.toleey.bbsmsg.pojo.Word;
import com.toleey.bbsmsg.service.word.WordService;

import java.util.List;

public class WordServiceImpl implements WordService {
    WordDaoImpl wordDaoImpl = new WordDaoImpl();
    @Override
    public List<Word> selectWord() {
        List<Word> wordList = null;
        try {
            wordList = wordDaoImpl.findWord(wordDaoImpl.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wordList;
    }
}
