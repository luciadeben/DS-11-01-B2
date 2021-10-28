package p3;

import java.util.*;

public class Network {

    private NetworkManager networkManager;

    public Network(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    public void altaUsuario(String usuario, List<TopicOfInterest> intereses){
        networkManager.addUser(usuario, intereses);
    }

    public  void bajaUsuario(String usuario){
        networkManager.removeUser(usuario);
    }

    public void agregarTemaInteres(String usuario, TopicOfInterest topicOfInterest){
        networkManager.addInterest(usuario, topicOfInterest);
    }

    public void eliminarTemaInteres(String usuario, TopicOfInterest topicOfInterest){
        networkManager.removeInterest(usuario, topicOfInterest);
    }

    public List<TopicOfInterest> temasInteresUsuario(String usuario){
        return networkManager.getInterestsUser(usuario);
    }

    public List<String> usuariosInteresadosTema(TopicOfInterest topicOfInterest){
        List<String> usuarios = networkManager.getUsers();
        List<String> interesados = new ArrayList<>();
        for(String usuario : usuarios){
            List<TopicOfInterest> interesUsuario = networkManager.getInterestsUser(usuario);
            if(interesUsuario.indexOf(topicOfInterest) != -1){
                interesados.add(usuario);
            }
        }
        return interesados;
    }

    public List<TopicOfInterest> temasInteresComun(String usuario1, String usuario2){
        List<TopicOfInterest> temasComunes = new ArrayList<>();
        List<TopicOfInterest> topicsUser1 = networkManager.getInterestsUser(usuario1);
        List<TopicOfInterest> topicsUser2 = networkManager.getInterestsUser(usuario2);

        if(topicsUser2.size() > 0 && topicsUser1.size() > 0) {

            for (TopicOfInterest topicUser1 : topicsUser1) {
                if (topicsUser2.indexOf(topicUser1) != -1) {
                    temasComunes.add(topicUser1);
                }
            }
        }

        return temasComunes;
    }

    public List<TopicOfInterest> temasInteresUsuariosRed(){
        return networkManager.getInterests();
    }

    public void mortrarRed(){
        List<TopicOfInterest> interesUsuario;
        List<String> usuarios = networkManager.getUsers();
        for (String usuario : usuarios) {
            System.out.print(usuario+": ");
            interesUsuario = networkManager.getInterestsUser(usuario);
            for (TopicOfInterest interes : interesUsuario) {
                System.out.print(interes + " ");
            }
            System.out.println();
        }
    }
}
