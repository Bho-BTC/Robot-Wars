package com.btcag.bootcamp.Hibernate.Interfaces;

import com.btcag.bootcamp.Enitites.MapEntity;
import com.btcag.bootcamp.Maps.Map;

public interface IMapServices {
    public MapEntity getBoard(int boardID);
}