package pojo;

import java.util.List;

public class pageBean<T> {
    private int totallCount ;
    private List<T> brands;

    public pageBean(int totallCount, List<T> brands) {
        this.totallCount = totallCount;
        this.brands = brands;
    }

    public pageBean() {
    }

    public int getTotallCount() {
        return totallCount;
    }

    public void setTotallCount(int totallCount) {
        this.totallCount = totallCount;
    }

    public List<T> getBrands() {
        return brands;
    }

    public void setBrands(List<T> brands) {
        this.brands = brands;
    }

    @Override
    public String toString() {
        return "pageBean{" +
                "totallCount=" + totallCount +
                ", brands=" + brands +
                '}';
    }
}
