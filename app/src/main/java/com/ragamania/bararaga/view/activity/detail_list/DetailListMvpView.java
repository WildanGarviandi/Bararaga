package com.ragamania.bararaga.view.activity.detail_list;

import com.ragamania.bararaga.model.DetailCoaches.Coaches;
import com.ragamania.bararaga.view.MvpView;

/**
 * Created by wildangarviandi on 10/28/16.
 */

public interface DetailListMvpView extends MvpView {

    void loadDetailCoach(Coaches coaches);
}
