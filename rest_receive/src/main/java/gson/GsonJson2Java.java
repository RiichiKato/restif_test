package gson;

import com.google.gson.Gson;

public class GsonJson2Java {
    public static void main(String[] args) {
    	//JSON形式をStringで取り込む、HTMLのbodyが取り込めるとヨシ！
        String json =
                "{" +
                "    \"nfinfo\": {" +
                "        \"nfInstanceID\": \"1111-2222-3333-4444\"," +
                "        \"nfType\": \"PCF\"," +
                "        \"nfStatus\": \"REGISTERED\"," +
                "        \"func\": [" +
                "            {\"type\": \"hoge\", \"name\": \"taro\"}," +
                "            {\"type\": \"fuga\", \"name\": \"hana\"}," +
                "        ]" +
                "    }" +
                "}";

        Gson gson = new Gson();
        NFProfile nfprofile = gson.fromJson(json, NFProfile.class);

        System.out.println("nfInstanceID:" + nfprofile.nfinstances.nfInstanceID);
        System.out.println("nfType:" + nfprofile.nfinstances.nfType);
        System.out.println("nfStatus:" + nfprofile.nfinstances.nfStatus);
        System.out.println("1st func:" + nfprofile.nfinstances.func.get(0).name);
        System.out.println("2nd func:" + nfprofile.nfinstances.func.get(1).name);
    }
}