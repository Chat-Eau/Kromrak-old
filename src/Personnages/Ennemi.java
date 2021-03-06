package Personnages;

import Evenements.Combat;
import Interface.KFrame;
import Objets.Arme;
import Objets.Objet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Outils.Constantes.SEP;
import static Outils.Outils.lancerDes;

public class Ennemi extends Personnage {
    int rarete;
    int tier;
    int noEnnemi;
    List<String> type = new ArrayList<>();

    public Ennemi() {
        cible = Kromrak.getInstance();
        this.nom = "Gobelin";
        Personnage cible = Kromrak.getInstance();

        lvl = 1;
        tier = 1;
        rarete = 1;

        reaction = false;
        vieMax = 5;
        vie = vieMax;
        force = 2;
        intelligence = 1;
        dextérité = 3;
        vitesse = lancerDes(1);
        endurance = 0;
        CA = 0;

        if (new Random().nextInt(3) == 0) {
            inventaire.add(new Arme("Épée courte et molle", 1, 0, 1, 3, "1Main"));
            this.arme = (Arme) inventaire.get(0);
        }
        for (int i = new Random().nextInt(5) + 10; 0 < i; i--) {
            inventaire.add(new Objet("Gemme de test", 4));
        }
    }
    public Ennemi(String ennemi) {
        this.nom = "";
        this.cible = Kromrak.getInstance();
        this.arme = null;
        reaction = false;

        rarete = 0;
        tier = 0;
        lvl = 0;
        vieMax = 0;
        vie = 0;
        force = 0;
        intelligence = 0;
        dextérité = 0;
        vitesse = 0;
        endurance = 0;
        CA = 0;

        //GLM: TOUJOURS passer le niveau en tant que premiere section dans la string.

        String[] sections = ennemi.split(" ; ");
        for (int i = 0; i < sections.length; i++){
            String[] unit = sections[i].split(":");
            switch(unit[0].toLowerCase()){
                case "niv":case "niveau": case "lvl":
                    lvl = Integer.parseInt(unit[1]);
                    break;
                case "nom":
                    nom = unit[1];
                    break;
                case "rarete":
                    rarete = Integer.parseInt(unit[1]);
                    break;
                case "tier":case "t":
                    tier = Integer.parseInt(unit[1]);
                    break;
                case "type":
                    String types[] = unit[1].split(",");
                    for (String donnee:types) {
                        type.add(donnee);
                    }
                    break;
                case "objet":case "objets":
                    //À faire
                    break;
                case "pièce":case "piece":case "or":
                    inventaire.add(Integer.parseInt(unit[1]));
                    break;
                case "pdv":case "vie":
                    vie += Integer.parseInt(unit[1]);
                    break;
                case "pvie":case "ppdv":
                    if (Integer.parseInt(unit[1]) != 0)
                        vie += (int) Math.floor(lvl / Integer.parseInt(unit[1]));
                    break;
                case "dpdv":case "dvie":
                    if (Integer.parseInt(unit[1]) != 0)
                        vie += lancerDes(Integer.parseInt(unit[1]));
                    break;
                case "pdvie":case "pdpdv":case "dpvie":case "dppdv":
                    if (Integer.parseInt(unit[1]) != 0)
                        vie += lancerDes((int) Math.floor(lvl / Integer.parseInt(unit[1])));
                    break;
                case "pdvmax":case "viemax":
                    vieMax += Integer.parseInt(unit[1]);
                    break;
                case "pviemax":case "ppdvmax":
                    if (Integer.parseInt(unit[1]) != 0)
                        vieMax += (int) Math.floor(lvl / Integer.parseInt(unit[1]));
                    break;
                case "dpdvmax":case "dviemax":
                    if (Integer.parseInt(unit[1]) != 0)
                        vieMax += lancerDes(Integer.parseInt(unit[1]));
                    break;
                case "pdviemax":case "pdpdvmax":case "dpviemax":case "dppdvmax":
                    if (Integer.parseInt(unit[1]) != 0)
                        vieMax += lancerDes((int) Math.floor(lvl / Integer.parseInt(unit[1])));
                    break;
                case "for":case "force":
                    force += Integer.parseInt(unit[1]);
                    break;
                case "pfor":case "pforce":
                    if (Integer.parseInt(unit[1]) != 0)
                        force += (int) Math.floor(lvl / Integer.parseInt(unit[1]));
                    break;
                case "dfor":case "dforce":
                    if (Integer.parseInt(unit[1]) != 0)
                        force += lancerDes(Integer.parseInt(unit[1]));
                    break;
                case "pdforce":case "pdfor":case "dpforce":case "dpfor":
                    if (Integer.parseInt(unit[1]) != 0)
                        force += lancerDes((int) Math.floor(lvl / Integer.parseInt(unit[1])));
                    break;
                case "int":case "intel":case "intelligence":
                    intelligence += Integer.parseInt(unit[1]);
                    break;
                case "pint":case "pintel":case "pintelligence":
                    if (Integer.parseInt(unit[1]) != 0)
                        intelligence += (int) Math.floor(lvl / Integer.parseInt(unit[1]));
                    break;
                case "dint":case "dintel":case "dintelligence":
                    if (Integer.parseInt(unit[1]) != 0)
                        intelligence += lancerDes(Integer.parseInt(unit[1]));
                    break;
                case "dpint":case "dpintel":case "dpintelligence":case "pdint":case "pdintel":case "pdintelligence":
                    if (Integer.parseInt(unit[1]) != 0)
                        intelligence += lancerDes((int) Math.floor(lvl / Integer.parseInt(unit[1])));
                    break;
                case "dex":case "dexterite":
                    dextérité += Integer.parseInt(unit[1]);
                    break;
                case "pdex":case "pdexterite":
                    if (Integer.parseInt(unit[1]) != 0)
                        dextérité += (int) Math.floor(lvl / Integer.parseInt(unit[1]));
                    break;
                case "ddex":case "ddexterite":
                    if (Integer.parseInt(unit[1]) != 0)
                        dextérité += lancerDes(Integer.parseInt(unit[1]));
                    break;
                case "pddex":case "pddexterite":case "dpdex":case "dpdexterite":
                    if (Integer.parseInt(unit[1]) != 0)
                        dextérité += lancerDes((int) Math.floor(lvl / Integer.parseInt(unit[1])));
                    break;
                case "vit":case "vitesse":
                    vitesse += Integer.parseInt(unit[1]);
                    break;
                case "pvit":case "pvitesse":
                    if (Integer.parseInt(unit[1]) != 0)
                        vitesse += (int) Math.floor(lvl / Integer.parseInt(unit[1]));
                    break;
                case "dvit":case "dvitesse":
                    if (Integer.parseInt(unit[1]) != 0)
                        vitesse += lancerDes(Integer.parseInt(unit[1]));
                    break;
                case "pdvit":case "pdvitesse":case "dpvit":case "dpvitesse":
                    if (Integer.parseInt(unit[1]) != 0)
                        vitesse += lancerDes((int) Math.floor(lvl / Integer.parseInt(unit[1])));
                    break;
                case "end":case "endurance":
                    endurance += Integer.parseInt(unit[1]);
                    break;
                case "pend":case "pendurance":
                    if (Integer.parseInt(unit[1]) != 0)
                        endurance += (int) Math.floor(lvl / Integer.parseInt(unit[1]));
                    break;
                case "dend":case "dendurance":
                    if (Integer.parseInt(unit[1]) != 0)
                        endurance += lancerDes(Integer.parseInt(unit[1]));
                    break;
                case "pdend":case "pdendurance":case "dpend":case "dpendurance":
                    if (Integer.parseInt(unit[1]) != 0)
                        endurance += lancerDes((int) Math.floor(lvl / Integer.parseInt(unit[1])));
                    break;
                case "ca":case "classearmure":
                    CA += Integer.parseInt(unit[1]);
                    break;
                case "pca":case "pclassearmure":
                    if (Integer.parseInt(unit[1]) != 0)
                        CA += (int) Math.floor(lvl / Integer.parseInt(unit[1]));
                    break;
                case "dca":case "dclassearmure":
                    if (Integer.parseInt(unit[1]) != 0)
                        CA += lancerDes(Integer.parseInt(unit[1]));
                    break;
                case "pdca":case "pdclassearmure":case "dpca":case "dpclassearmure":
                    if (Integer.parseInt(unit[1]) != 0)
                        CA += lancerDes((int) Math.floor(lvl / Integer.parseInt(unit[1])));
                    break;
            }
        }

        if (vieMax < 1){
            vieMax = 1;
        }
        if (vie < 1){
            vie = 1;
        }
        if (vie > vieMax){
            vieMax = vie;
        }

        if (new Random().nextInt(3) == 0) {
            this.arme = (new Arme("Épée courte et molle", 1, 0, 1, 3, "1Main"));
            inventaire.add(this.arme);
        }
    }
    public void recevoirDegats (int nbDegats)
    {
        int reactionChoisie = -1;
        Random random = new Random();
        if (reaction){
            reactionChoisie = random.nextInt(2);
            reaction = false;
        } else {
            super.recevoirDegats(nbDegats);
        }

        if (reactionChoisie == 0){
            super.recevoirDegats(nbDegats);
            System.out.println(SEP + this.getNom() + " contre-attaque!");
            KFrame.getInstance().textPanel.zoneTexte.addTextln(SEP + this.getNom() + " contre-attaque!");
            this.attaquer();
        } else if (reactionChoisie == 1){
            System.out.println(this.getNom() + " esquive l'attaque de " + nbDegats + " dommages.");
            KFrame.getInstance().textPanel.zoneTexte.addTextln(this.getNom() + " esquive l'attaque de " + nbDegats + " dommages.");
        }
    }

    public void jouerTour(Combat combat){
        System.out.print("Au tour de " + getNom() + ": ");
        KFrame.getInstance().textPanel.zoneTexte.addText("Au tour de " + getNom() + ": ");
        attaquer();
    }

    protected void reactionEnnemi() {
        if (new Random().nextInt(3) == 0) {
            System.out.print(getNom() + " bloque l'attaque et ");
            KFrame.getInstance().textPanel.zoneTexte.addTextln(getNom() + " bloque l'attaque et ");
            activerParade();
        } else {
            System.out.println(getNom() + " contre-attaque!" + SEP);
            KFrame.getInstance().textPanel.zoneTexte.addTextln(getNom() + " contre-attaque!" + SEP);
            attaquer();
        }
    }

    public void setNoEnnemi(int noEnnemi){
        this.noEnnemi = noEnnemi;
    }

    public int getNoEnnemi(){ return noEnnemi; }

    @Override
    public int attaquer() {
        cible = Kromrak.getInstance();
        Kromrak.getInstance().setCible(this);
        return super.attaquer();
    }
}
