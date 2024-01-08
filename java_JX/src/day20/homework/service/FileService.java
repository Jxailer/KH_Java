package day20.homework.service;

import java.util.List;

import day10.word.Word;

public interface FileService {
public List<day20.homework.Word> load(String fileName);
public boolean save(String fileName, List<Word> list);
}
