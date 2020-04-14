package nl.hva.ict.controllers;

import nl.hva.ict.views.BoekingsoverzichtView;
import nl.hva.ict.views.View;

public class BoekingsOverzichtController extends Controller {

    private BoekingsoverzichtView boekingsoverzichtView;

    public BoekingsOverzichtController() {
        boekingsoverzichtView = new BoekingsoverzichtView();
    }

    @Override
    public View getView() {
        return boekingsoverzichtView;
    }
}
