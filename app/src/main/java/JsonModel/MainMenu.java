package JsonModel;

import com.google.gson.annotations.SerializedName;

public class MainMenu {
    @SerializedName("id")
    private int _id;
    @SerializedName("name")
    private String titleItem;
    @SerializedName("background")
    private String backroundItemPath;

    public int get_id() {
        return _id;
    }

    public String getTitleItem() {
        return titleItem;
    }

    public String getBackroundItemPath() {
        return backroundItemPath;
    }

}
