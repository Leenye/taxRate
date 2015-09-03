import java.util.Map;

/**
 * Created by twer on 9/1/15.
 */
public class CartItem {
    private Map<Goods,String> goodsMap;
    private  double costs;

    public Map<Goods, String> getGoodsMap() {
        return goodsMap;
    }
    public double getCosts() {
        return costs;
    }

    public void setGoodsMap(Map<Goods, String> goodsMap) {
        this.goodsMap = goodsMap;
    }

    public void setCosts(double costs) {
        this.costs = costs;
    }
}
