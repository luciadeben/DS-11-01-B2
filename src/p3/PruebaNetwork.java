package p3;

import java.util.ArrayList;
import java.util.List;

public class PruebaNetwork {

    public static void main(String[] args) {

        //Network net = new Network(new NetworkManagerTab());
        Network net = new Network(new NetworkManagerMap());

        String usuario1 = "Ana";
        List<TopicOfInterest> interesesUsuario1 = new ArrayList<>();
        interesesUsuario1.add(TopicOfInterest.CINE);
        interesesUsuario1.add(TopicOfInterest.ECONOMIA);

        String usuario2 = "Pedro";
        List<TopicOfInterest> interesesUsuario2 = new ArrayList<>();
        interesesUsuario2.add(TopicOfInterest.VIAJES);
        interesesUsuario2.add(TopicOfInterest.DANZA);
        interesesUsuario2.add(TopicOfInterest.LECTURA);

        net.altaUsuario(usuario1, interesesUsuario1);
        net.altaUsuario(usuario2, interesesUsuario2);

        net.agregarTemaInteres(usuario1, TopicOfInterest.VIAJES);

        net.mortrarRed();

        System.out.println("Temas en comun");
        List<TopicOfInterest> temasComunes = net.temasInteresComun(usuario1, usuario2);
        for (TopicOfInterest topic : temasComunes){
            System.out.print(topic + " ");
        }
        System.out.println();

        System.out.println("Interesados en CINE");
        List<String> usuariosTema = net.usuariosInteresadosTema(TopicOfInterest.CINE);
        for (String user : usuariosTema){
            System.out.print(user + " ");
        }
        System.out.println();

        System.out.println("Ana se da de baja");
        net.bajaUsuario("Ana");
        net.mortrarRed();
    }
}
