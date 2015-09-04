import java.util.Map;

/**
 * Created by twer on 9/1/15.
 */
public class CartItem {

    private Goods goods;
    private int num;

    public Goods getGoods() {
        return goods;
    }

    public int getNum() {
        return num;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public CartItem(Goods goods,int num){
        this.goods = goods;
        this.num = num;
    }

    public CartItem() {
    }
}
