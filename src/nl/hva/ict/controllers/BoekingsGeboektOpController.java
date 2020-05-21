package nl.hva.ict.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import nl.hva.ict.MainApplication;
import nl.hva.ict.models.Accommodatie;
import nl.hva.ict.models.Reiziger;
import nl.hva.ict.views.GeboektOpView;
import nl.hva.ict.views.View;

import java.time.LocalDate;

public class BoekingsGeboektOpController extends Controller {

    private GeboektOpView geboektOpView;

    public BoekingsGeboektOpController() {
        geboektOpView = new GeboektOpView();
        geboektOpView.getComboBoxAccommodaties().getSelectionModel().selectedItemProperty().addListener(event -> ListAccommodaties());
        load();
    }
    private void load() {
        ObservableList<Accommodatie> accommodaties = FXCollections.observableArrayList(MainApplication.getMySQLAccommodaties().getAll());
        geboektOpView.getComboBoxAccommodaties().setItems(accommodaties);
    }

    private void ListAccommodaties() {

        Accommodatie accommodatieSelected = (Accommodatie) geboektOpView.getComboBoxAccommodaties().getSelectionModel().getSelectedItem();
        String accommodatieCode = accommodatieSelected.getAccommodatieCode();
        LocalDate datum = geboektOpView.getDatePicker().getValue();
        // haal DB info op

        ObservableList<Reiziger> reizigers = FXCollections.observableArrayList(MainApplication.getMySQLBoekingsOverzicht().GeboektOp(accommodatieCode, datum));
        geboektOpView.getBoekingsOverzichtListView().setItems(reizigers);
    }


    @Override
    public View getView() {
        return geboektOpView;
    }
}
