package nl.hva.ict.data.MongoDB;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import nl.hva.ict.models.Reiziger;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoReizigers extends MongoDB {

    private final List<Reiziger> reizigers;

    public MongoReizigers() {
        reizigers = new ArrayList<>();
        load();
    }

    @Override
    public List getAll() {
        return reizigers;
    }

    @Override
    public Object get(String id) {
        return null;
    }

    @Override
    public void add(Object object) {

    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void remove(Object object) {

    }

    public Reiziger getOneReizigers(String reizigersId){
        this.selectedCollection("reizigers");
        Document myDoc = collection.find(Filters.eq("reizigerscode", reizigersId)).first();
        String reizigersCode = (String)myDoc.get("reizigerCode");
        String voornaam = (String)myDoc.get("voornaam");
        String achternaam = (String)myDoc.get("achternaam");
        String adres = (String)myDoc.get("adres");
        String postcode = (String)myDoc.get("postcode");
        String plaats = (String)myDoc.get("plaats");
        String land = (String)myDoc.get("land");
        String hoofdreiziger = (String)myDoc.get("hoofdreiziger");
        return new Reiziger(reizigersCode, voornaam, achternaam, adres, postcode, plaats, land, hoofdreiziger);
    }


    public void load(){
        this.selectedCollection("reiziger");
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {

                Document tempReiziger = cursor.next();
                String reizigersCode = (String)tempReiziger.get("reizigersCode");
                String voornaam = (String)tempReiziger.get("voornaam");
                String achternaam = (String)tempReiziger.get("achternaam");
                String adres = (String)tempReiziger.get("adres");
                String postcode = (String)tempReiziger.get("postcode");
                String plaats = (String)tempReiziger.get("plaats");
                String land = (String)tempReiziger.get("land");
                String hoofdreiziger = (String)tempReiziger.get("hoofdreiziger");
                Reiziger reiziger = new Reiziger(reizigersCode, voornaam, achternaam, adres, postcode, plaats, land, hoofdreiziger);
                reizigers.add(reiziger);
            }
        } finally {
            cursor.close();
        }
    }
}

