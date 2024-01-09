package day20.homework.service;

import java.util.List;

import day20.homework.Word;



public interface FileService {
public List<Word> load(String fileName);
public boolean save(String fileName, List<day20.homework.Word> list);
}
