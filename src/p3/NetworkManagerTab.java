package p3;

import java.util.ArrayList;
import java.util.List;

public class NetworkManagerTab implements NetworkManager{

    //Ej.
    //["Ana", "Pedro", "Juan"]
    //[[MUSICA, VIAJES], [ECONOMIA, VIAJES], [CINE, TEATRO, ECONOMIA]]
    private List<String> usuarios;
    private List<List<TopicOfInterest>> intereses;

    public NetworkManagerTab() {
        usuarios = new ArrayList<>();
        intereses = new ArrayList<>();
    }

    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        if(usuarios.indexOf(user) == -1){
            //Se añade el usuario si no se encuentra
            usuarios.add(user);
            intereses.add(topicsOfInterest);
        }
    }

    @Override
    public void removeUser(String user) {
        int posicion = usuarios.indexOf(user);
        if(posicion != -1){
            usuarios.remove(posicion);
            intereses.remove(posicion);
        }
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        int posicion = usuarios.indexOf(user);
        if(posicion != -1){
            intereses.get(posicion).add(topicOfInterest);
        }
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        int posicionUsuario = usuarios.indexOf(user);
        if(posicionUsuario != -1){
            intereses.get(posicionUsuario).remove(topicOfInterest);
        }
    }

    @Override
    public List<String> getUsers() {
        return usuarios;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> resultado = new ArrayList<>();
        for (List<TopicOfInterest> interesesUsuario : intereses) {
            for (TopicOfInterest interes : interesesUsuario) {
                if(resultado.indexOf(interes) != -1)
                    resultado.add(interes);
            }
        }
        return resultado;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {

        int posicion = usuarios.indexOf(user);
        if(posicion != -1){
            return intereses.get(posicion);
        }
        else return null;
    }
}
