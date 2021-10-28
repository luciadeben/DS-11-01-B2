package p3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkManagerMap implements  NetworkManager{

    private Map<String, List<TopicOfInterest>> network;

    public NetworkManagerMap() {
        network = new HashMap<>();
    }

    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        network.put(user, topicsOfInterest);
    }

    @Override
    public void removeUser(String user) {
        network.remove(user);
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        network.get(user).add(topicOfInterest);
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        network.get(user).remove(topicOfInterest);
    }

    @Override
    public List<String> getUsers() {
        return new ArrayList<>(network.keySet());
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> resultado = new ArrayList<>();

        for(String user : network.keySet()){
            for(TopicOfInterest interesUsuario : network.get(user)){
                if(resultado.indexOf(interesUsuario) != -1)
                    resultado.add(interesUsuario);
            }
        }

        return resultado;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        return network.get(user);
    }
}
