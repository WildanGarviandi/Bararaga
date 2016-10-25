package com.ragamania.bararaga.view.fragment.places;

import com.ragamania.bararaga.model.PlacesList;
import com.ragamania.bararaga.view.MvpView;

import java.util.List;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public interface PlacesMvpView extends MvpView {

    void loadPlacesList(List<PlacesList> placesList);
}
