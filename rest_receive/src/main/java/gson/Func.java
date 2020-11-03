package gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Func {
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("name")
    @Expose
    public String name;
}