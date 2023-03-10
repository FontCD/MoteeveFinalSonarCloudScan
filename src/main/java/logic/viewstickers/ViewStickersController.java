package logic.viewstickers;


import logic.dao.StickerDAOJDBC;
import logic.factory.StickerFactory;
import logic.model.Sticker;

import java.util.ArrayList;
import java.util.List;

//CONTROLLER A CUI E' AFFIDATA LA CREAZIONE DI UNA LISAT DIS TICKER
public class ViewStickersController {

    //METODO PER CREARE UNA LISTA DI STICKER CON I DATI RECUPERATI DAL DATABASE
    public  ViewStickerListBean createStkList() {
        int stkInd = 1 ;
        int maxSticker = 11;
        List<Sticker> listStk = new ArrayList<>();

        StickerDAOJDBC dao = new StickerDAOJDBC();
        StickerFactory factory = new StickerFactory();

        do {
            String name = dao.extractName(stkInd);
            String url = dao.extractStickerUrl(stkInd);
            boolean status = dao.extractStatus(stkInd);

            Sticker stk = factory.createSticker(stkInd, name, url, status);

            listStk.add(stk) ;
            stkInd = stkInd + 1 ;

        } while (stkInd != maxSticker +1) ;

        ViewStickerListBean bean = new ViewStickerListBean();
        bean.setBean(listStk);

        return bean;
    }

}
