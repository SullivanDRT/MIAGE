package fr.info.orleans.ws.modele;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProxyGestionCafeWSImpl implements ProxyGestionCafeWS {


    private ObjectMapper mapper = new ObjectMapper();
    private XmlMapper mapperXML = new XmlMapper();
    private HttpClient client = HttpClient.newHttpClient();



    @Override
    public String inscription(String emailText, String nomText, String prenomText) throws ConflitEmailException, DonneesIncompletesException, IOException, InterruptedException {

        UtilisateurDTO user = new UtilisateurDTO();
        user.setEmail(emailText);
        user.setNom(nomText);
        user.setPrenom(prenomText);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/cafews/compte"))
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(user)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String cleSecrete = "";
        if(response.statusCode() == 201){
            cleSecrete = response.body();
        }
        else if(response.statusCode()==409){
            throw new ConflitEmailException();
        }
        else if(response.statusCode()==400){
            throw new DonneesIncompletesException();
        }
        System.out.println(cleSecrete);
        return cleSecrete;
    }



    @Override
    public UtilisateurDTO connexion(String cleSecreteText) throws MauvaiseCleSecreteException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/cafews/compte/" + cleSecreteText))
                .header("Content-type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        UtilisateurDTO utilisateur = new UtilisateurDTO();
        if(response.statusCode() == 200){
            utilisateur = mapper.readValue(response.body(), UtilisateurDTO.class);
        }
        else if(response.statusCode()==401){
            throw  new MauvaiseCleSecreteException();
        }
        return utilisateur;
    }

    @Override
    public Collection<RechargeCafeDTO> getRecharges(String cleSecrete, Filtre filtreCourant) throws IOException, InterruptedException, DonneesIncompletesException, MauvaiseCleSecreteException {
         String buildUri =  "http://localhost:8080/api/cafews/recharge/" + cleSecrete;
         if(filtreCourant != null){
             buildUri = buildUri + "?";
             if(filtreCourant.isPerso()){
                 buildUri += "perso=true";
             }
             else{
                 buildUri += "perso=false";
             }
             System.out.println("filtre" + filtreCourant.getDebut());
             if(!filtreCourant.getDebut().equals(null)){
                buildUri += "&dateDebut=" + filtreCourant.getDebut();
             }
             if(!filtreCourant.getFin().equals("")) {
                 buildUri += "&dateFin=" + filtreCourant.getFin();
             }
         }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(buildUri))
                .header("Content-type","application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Collection<RechargeCafeDTO> recharges = new ArrayList();
        if(response.statusCode() == 200){
            recharges = mapper.readValue(response.body(),  mapper.getTypeFactory().constructCollectionType(Collection.class, RechargeCafeDTO.class));
        }
        else if(response.statusCode()==400){
            throw new DonneesIncompletesException();
        }
        else if(response.statusCode()==401){
            throw new MauvaiseCleSecreteException();
        }
        return recharges;
    }

    @Override
    public String creerRecharge(String cleSecrete, int nbKilos) throws PoidsIncorrectException {

        return null;

    }
}
