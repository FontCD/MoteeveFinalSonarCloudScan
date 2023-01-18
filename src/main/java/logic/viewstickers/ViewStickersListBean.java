package logic.viewstickers;

import logic.model.Sticker;

import java.util.List;

public class ViewStickersListBean {

    private List<Sticker> list;

    public void setBean(List<Sticker> list) {
        this.list = list;
    }

    public List<Sticker> getBean() {
        return this.list;
    }

}
