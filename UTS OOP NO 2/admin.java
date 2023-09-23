import java.util.ArrayList;

public class admin extends user {
    public admin(String name, String username, String password) {
        super(name, username, password);
    }      

    public static ArrayList<project> delete_project(ArrayList<project> project, int idx){
        project.remove(idx);
        return project;
    }

    public static ArrayList<client> delete_client(ArrayList<client> client, int idx){
        client.remove(idx);
        return client;
    }
    
    public static ArrayList<freelancer> delete_freelancer(ArrayList<freelancer> freelancer, int idx){
        freelancer.remove(idx);
        return freelancer;
    }   
    
    public static String view_freelancer(ArrayList<freelancer> freelancer, int idx){
        return freelancer.get(idx).getName();        
    }  

    public static String view_client(ArrayList<client> client, int idx){
        return client.get(idx).getName();        
    } 

    public static String view_project(ArrayList<project> project, int idx){
        return project.get(idx).getName();        
    } 
}


