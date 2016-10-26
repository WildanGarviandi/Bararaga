package com.ragamania.bararaga.view.fragment.coaches;

import com.ragamania.bararaga.model.CoachesList;
import com.ragamania.bararaga.view.MvpView;

import java.util.List;

/**
 * Created by wildangarviandi on 10/8/16.
 */

public interface CoachesMvpView extends MvpView {

    void loadCoachesList(List<CoachesList> coachesList);
}
