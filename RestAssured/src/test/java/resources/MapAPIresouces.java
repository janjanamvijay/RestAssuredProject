package resources;
//enum is special class which contains collection of constants and methods.
//all the methods related to a particular should seperate with ,(coma) once declared all the methods then put';' to indicate that end of functions.

public enum MapAPIresouces {
    addAddress("/maps/api/place/add/json"),
    getAddress("/maps/api/place/add/json"),
     deleteAddress("/maps/api/place/add/json");
String path;

    MapAPIresouces(String path) {
        String path1= null;
    }
    public String getPath(){
        return path;
    }
}
