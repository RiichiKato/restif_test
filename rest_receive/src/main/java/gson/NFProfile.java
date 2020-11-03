package gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//NFProfileのクラス(親)
public class NFProfile {

    @SerializedName("nfinstances")
    @Expose
    public NFInstances nfinstances;

}