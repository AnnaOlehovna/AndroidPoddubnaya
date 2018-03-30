package com.olehovnagmail.anya.homeworks.homework6.parsing;

import com.olehovnagmail.anya.homeworks.homework6.entity.Root;

import java.io.File;

public interface Parsing {

    /**
     * Parsing data from files to entity
     * @param file  for parsing
     */
    Root parsingFile(File file);
}

