
package com.ragamania.bararaga.model.ArticleDetail;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class News {

    /**
     * title : 7 Tips Mempertahankan Nafasmu Saat Melakukan Long Running
     * icon_cource : https://static.glassdoor.com/static/img/mobile/icons/touch-icon-57.png
     * source_name : hellosehat.com
     * detail : Pancasila sebagai dasar negara merupakan suatu asas kerohanian yang meliputi suasana kebatinan atau cita-cita hukum sehingga merupakan suatu sumber nilai norma serta kaidah, baik moral maupun hukum negara, dan menguasai hukum dasar, baik yang tertulis (Undang-Undang Dasar) maupun yang tidak tertulis (konvensi). Dalam kedudukannya sebagai dasar negara, Pancasila mempunyai kekuatan mengikat secara hukum. Oleh karena itu, Pancasila sebagai dasar negara memiliki arti penting dalam mengatur pemerintahan negara. Artinya, seluruh pelaksanaan dan penyelenggaraan negara terutama peraturan perundang-undangan merupakan penjabaran dari nilai-nilai Pancasila. Dengan demikian, dasar negara juga merupakan penjabaran nilai-nilai ﬁlosoﬁs suatu bangsa. Nilai-nilai ﬁlosoﬁs tersebut, di antaranya musyawarah mufakat, percaya kepada Tuhan YME, persamaan derajat, dan rela berkorban.
     * action : {}
     */

    private String title;
    private String icon_cource;
    private String source_name;
    private String detail;
    private Action action;

    public static List<News> arrayNewsFromData(String str) {

        Type listType = new TypeToken<ArrayList<News>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon_cource() {
        return icon_cource;
    }

    public void setIcon_cource(String icon_cource) {
        this.icon_cource = icon_cource;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
