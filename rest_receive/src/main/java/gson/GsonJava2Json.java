package gson;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonJava2Json {
    public static void main(String[] args) {

        NFProfile nfprofile = new NFProfile();
        nfprofile.nfinstances = new NFInstances();
        nfprofile.nfinstances.nfInstanceID = "pcf-nrfControl";
        nfprofile.nfinstances.nfType = "PCF";
        nfprofile.nfinstances.nfStatus = "REGISTERED";
        nfprofile.nfinstances.func = new ArrayList<Func>();
        Func func1 = new Func();
        func1.type = "AAA";
        func1.name = "AAA-TEST";
        nfprofile.nfinstances.func.add(func1);
        Func func2 = new Func();
        func2.type = "BBB";
        func2.name = "BBB-TEST";
        nfprofile.nfinstances.func.add(func2);
        Gson gson = new Gson();

        String json = gson.toJson(nfprofile);
        System.out.println(json);

        // JSONをフォーマット(Pretty Printing)する
        Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson2.toJson(nfprofile);
        System.out.println(prettyJson);

    }
}