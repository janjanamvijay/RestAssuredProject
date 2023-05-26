package resources;

import pojoClasses.AddAddress;
import pojoClasses.Location;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    public AddAddress mapsPayloadData(String Name,int Accuracy,String Phone_number,String Website,String Language){
        AddAddress add = new AddAddress();


        add.setName(Name);
        add.setAccuracy(Accuracy);
        add.setPhone_number(Phone_number);
        add.setWebsite(Website);
        add.setLanguage(Language);
        add.setAddress("29, side layout, cohen 09");
        List<String> types= new ArrayList<String>();

        types.add("shop");
        types.add("shoe park");

        Location loc = new Location();
        loc.setLat(-12.344);
        loc.setLng(-99.99);
        return add;
    }


}
