package gson;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//NFInstancesのクラス(NFProfileの子)
public class NFInstances {

    @SerializedName("nfInstanceID")
    @Expose
    public String nfInstanceID;
    @SerializedName("nfType")
    @Expose
    public String nfType;
    @SerializedName("nfStatus")
    @Expose
    public String nfStatus;
    @SerializedName("func")
    @Expose
    public List<Func> func = null;


}