package s2017s16.kr.hs.mirim.silvernow.gym;

public class GymDataModel {
    private String item_title;
    private int item_image;
    private Class item_link;

    public GymDataModel(String item_title, int item_image, Class item_link) {
        this.item_title = item_title;
        this.item_image = item_image;
        this.item_link = item_link;
    }

    public String getItem_title() {
        return item_title;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }

    public int getItem_image() {
        return item_image;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }

    public Class getItem_link() {
        return item_link;
    }

    public void setItem_link(Class item_link) {
        this.item_link = item_link;
    }
}
