package com.olehovnagmail.anya.data.homework6.parsing;


import com.olehovnagmail.anya.data.homework6.weatherEntity.Root;

import java.io.File;

import io.reactivex.Observable;

public interface Parsing {

    /**
     * Parsing data from files to entity
     * @param file  for parsing
     */

    Observable<Root> parsingFile(File file);
}

